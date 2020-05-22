Calendar calendar = Calendar.getInstance();
System.out.println(calendar.getTime());
System.out.println(calendar.getTimeInMillis());//your current time in long (milliseconds)
calendar.set(Calendar.HOUR_OF_DAY, -24);
System.out.println(calendar.getTime());
System.out.println(calendar.getTimeInMillis());//time, 24 hours earleir in long (milliseconds)