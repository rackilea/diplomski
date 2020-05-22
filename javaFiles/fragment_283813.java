public long yourMethod() throws ParseException {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date1 = sdf1.parse(start);
    long startTime = date1.getTime();

    return startTime;
}