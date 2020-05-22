Calendar calendar = Calendar.getInstance();     
    java.sql.Date userSignupdate = ...;
    calendar.setTimeInMillis( userSignupdate );

    // maxDay will hold the maximum date of the month. {28,29,30,31}
    int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);