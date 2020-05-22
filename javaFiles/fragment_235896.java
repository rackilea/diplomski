Calendar calendar = Calendar.getIstance();
calendar.setTime(myDate);
int hourToSeconds = calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60;
int minutesToSeconds = calendar.get(Calendar.MINUTE) * 60;

int totalSeconds = hourToSeconds + minutesToSeconds ;
Long alertTimeCatcher = new GregorianCalendar().getTimeInMillis()+ totalSeconds *1000;