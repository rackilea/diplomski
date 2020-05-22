public static TextWatcher amount(final EditText editText, final String metric) {
    return new TextWatcher() {
        String current = "";

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().equals(current)) {
                editText.removeTextChangedListener(this);

                String cleanString = s.toString();

                if (count != 0) {
                    String substr = cleanString.substring(cleanString.length() - 2);

                    if (substr.contains(".") || substr.contains(",")) {
                        cleanString += "0";
                    }
                }

                cleanString = cleanString.replaceAll("[,.]", "");

                double parsed = Double.parseDouble(cleanString);
                DecimalFormat df = new DecimalFormat("0.00");
                String formatted = df.format((parsed / 100));

                current = formatted;
                editText.setText(formatted);
                editText.setSelection(formatted.length());

                editText.addTextChangedListener(this);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void afterTextChanged(Editable s) {}
    };
}