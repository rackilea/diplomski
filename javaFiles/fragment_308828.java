GregorianCalendar calendar1 = new GregorianCalendar();
GregorianCalendar calendar2 = new GregorianCalendar();

calendar1.set(Calendar.HOUR_OF_DAY, hour1);
calendar1.set(Calendar.MINUTE, min1);
calendar2.set(Calendar.HOUR_OF_DAY, hour2);
calendar2.set(Calendar.MINUTE, min2);

long millisCal1 = calendar1.getTimeInMillis();
long millisCal2 = calendar2.getTimeInMillis();

if (millisCal2 - millisCal1 >= 1000 * 60 * 3){
    // They differ of at least three mins
} else {
    // They not differ of at least three mins
}