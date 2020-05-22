Calendar c = Calendar.getInstance();
c.set(Calendar.HOUR_OF_DAY, 17);
System.out.println(c.get(Calendar.HOUR_OF_DAY));
System.out.println(c.get(Calendar.HOUR));
System.out.println(c.get(Calendar.AM_PM));

c.set(Calendar.HOUR_OF_DAY, 5);
System.out.println(c.get(Calendar.HOUR_OF_DAY));
System.out.println(c.get(Calendar.HOUR));
System.out.println(c.get(Calendar.AM_PM));