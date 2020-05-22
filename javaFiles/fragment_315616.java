private void calculateMaxValue() {
    try {
        if (formatter.getMaximum() != null) {
            String no = formatter.valueToString(formatter.getMaximum());
            // Get DecimalFormatSymbols instance of Locale.US
            char seperator = java.text.DecimalFormatSymbols.getInstance(java.util.Locale.US).getGroupingSeparator();
            no = no.replace(String.valueOf(seperator), "");
            MAX_VALUE = Double.parseDouble(no);
        }
    } catch (ParseException ex) {
        Utility.logs.log(Level.SEVERE, null, ex);
    }
}