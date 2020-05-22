SimpleDateFormat sdf = new SimpleDateFormat();
Calendar calendar = Calendar.getInstance();

calendar.set(Calendar.MONTH, 1);
System.out.println(sdf.format(calendar.getTime()));

calendar.set(Calendar.MONTH, 1);
System.out.println(sdf.format(calendar.getTime()));