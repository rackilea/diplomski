public static Date[] toDateArray(final String[] dateStrings)
throws ParseException{
    final Date[] arr = new Date[dateStrings.length];
    int pos = 0;
    final DateFormat df = new SimpleDateFormat("K:mm:ss a");
    for(final String input : dateStrings){
        arr[pos++] = df.parse(input);
    }
    return arr;
}