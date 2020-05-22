GregorianCalendar date = new GregorianCalendar();
date.clear();
//Use Gregorian calendar for all values
date.setGregorianChange(new Date(Long.MIN_VALUE));

date.setTimeZone( TimeZone.getTimeZone("UTC"));
date.setTime(new Date(-62135596800000L));

System.out.println(
        date.get(GregorianCalendar.YEAR) + "-" +
        (date.get(GregorianCalendar.MONTH) + 1) + "-" + 
        date.get(GregorianCalendar.DAY_OF_YEAR) + " " +
        date.get(GregorianCalendar.HOUR_OF_DAY) + ":" +
        date.get(GregorianCalendar.MINUTE) + ":" + 
        date.get(GregorianCalendar.SECOND) + "." +
        date.get(GregorianCalendar.MILLISECOND)
);
//Prints 1-1-1 0:0:0.0