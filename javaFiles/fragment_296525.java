Calendar cal = Calendar.getInstance();
cal.set(2011, 5, 10);

ArrayList<Date> datesList = new ArrayList<Date>();

datesList.add(cal.getTime());

cal.add(Calendar.DATE, 1);
datesList.add(cal.getTime());

cal.add(Calendar.DATE, 1);
datesList.add(cal.getTime());

System.out.println( datesList.toString());