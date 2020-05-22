public static Date convertUtilDateToSqlDate(java.util.Date date){
        if(date != null && !(date.equals(""))) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }