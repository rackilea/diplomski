DateUtil.setShortDateDisplayFormatter(new DateDisplayFormatter() {
    public String format(Date date) {
        if(date == null) {
            return null;
        }
        DateTimeFormat dateFormatter = DateTimeFormat.getFormat("dd-MM-yyyy"+ "T"+"HH:mm:ss");
        return dateFormatter.format(date, TimeZone.createTimeZone(0));
    }
});