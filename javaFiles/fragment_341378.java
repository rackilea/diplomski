final String regex = "^\-?(\d{0,5}|\d{0,5}\.\d{0,3})$";
((EditText)rootView.findViewById(R.id.editText1)).setFilters(new InputFilter[] {
    new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned destination, int destinationStart, int destinationEnd) {
            if (end > start) {
                // adding: filter   
                // build the resulting text
                String destinationString = destination.toString();
                String resultingTxt = destinationString.substring(0, destinationStart) + source.subSequence(start, end) + destinationString.substring(destinationEnd);
                // return null to accept the input or empty to reject it
                return resultingTxt.matches(regex) ? null : "";
            }
            // removing: always accept
            return null;
        }
    }
});