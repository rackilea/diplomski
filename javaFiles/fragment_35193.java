public static String sqlDateToString(java.sql.Date date){
    if(date != null) {
        java.util.Date utilDate = new java.util.Date(date.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return dateFormat.format(utilDate);
    }
    return null;
}