Calendar cal = Calendar.getInstance();
System.out.println(new SimpleDateFormat("dd-MM-yy HH:mm:ss.S").format(cal.getTime()));

cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

System.out.println(new SimpleDateFormat("dd-MM-yy HH:mm:ss.S").format(cal.getTime()));