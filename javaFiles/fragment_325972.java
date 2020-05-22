Calendar myDate = Calendar.getInstance();   // returns GregorianCalendar
Calendar now = (Calendar)myDate.clone();    // save current timestamp
myDate.clear(); // this clears the fields, including Calendar.ZONE_OFFSET
myDate.set(     //set all fields back from the saved copy
    now.get(Calendar.YEAR),
    now.get(Calendar.MONTH),
    now.get(Calendar.DAY_OF_MONTH),
    now.get(Calendar.HOUR_OF_DAY),
    now.get(Calendar.MINUTE),
    now.get(Calendar.SECOND)
);