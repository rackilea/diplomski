public static Date convertStringtoDate(String stringDate){
    stringDate = StringUtils.trimToNull(stringDate);
    SimpleDateFormat dfm = new SimpleDateFormat("dd-MMM-yyyy");
    Date date = null;
    if(stringDate!=null){
        try {
            date = dfm.parse(stringDate);
        } catch (Exception e) {
            logger.info("Cannot convert String to Date: ", e);
        }
    }
    return date;    
}