public long yourMethod() {
    long startTime = -1L;
    try {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1 = sdf1.parse(start);
        startTime = date1.getTime();
    }
    catch (ParseException e) {
        // something went wrong
    }

    return startTime;
}