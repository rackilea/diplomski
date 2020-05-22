static void setCalendarDate(final Calendar cal, final String date) throws ParseException{       
    String separator = String.valueOf(date.charAt(4));
    if(Arrays.asList(validSeparators).contains(separator)) {
        final String[] splitDate = date.split(separator);
        cal.set(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[2]));
    } else {
        throw new ParseException("Valid separator not found", 0);
    }
}