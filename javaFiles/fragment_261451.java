public String convertTimeWithTimeZome(long time){
    Calendar cal = Calendar.getInstance();
    cal.setTimeZone(TimeZone.getTimeZone("UTC"));
    cal.setTimeInMillis(time);
    return (cal.get(Calendar.YEAR) + " " + (cal.get(Calendar.MONTH) + 1) + " " 
            + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.HOUR_OF_DAY) + ":"
            + cal.get(Calendar.MINUTE));

}