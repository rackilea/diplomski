int yourDays = -daysVariable;
int yourHours = -hoursVariable; //
Calendar cal = Calendar.getInstance();
cal.setTime(yourDate);
cal.add(Calendar.DAY_OF_MONTH, yourDays); //decrement days
cal.add(Calendar.HOUR_OF_DAY, yourHours); //decrement hours
cal.getTime(); //to get Date instance