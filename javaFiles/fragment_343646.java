public static DateTime convertSqlDateToDateTime(java.sql.Date sqlDate){
    Calendar c = Calendar.getInstance();
    c.setTime(sqlDate);
    //note: java months are between 0 and 11:
    DateTime dt=new DateTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND),c.get(Calendar.MILLISECOND));
    return dt;
}