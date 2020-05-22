static void setCalendarDate(final Calendar cal, final String date) throws ParseException{
    String separator = null;
    for(String s : validSeparators) {
        if(date.contains(s)) {
            separator = s;
            break;
        }
    }
    if(separator == null) {
        throw new ParseException("No valid separator found", 0);
    }

    final String[] splitDate = date.split(separator);
    cal.set(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[2]));
}