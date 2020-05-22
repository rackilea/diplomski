SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
Calendar c = Calendar.getInstance();
System.out.println(c.get(Calendar.DAY_OF_WEEK));
System.out.println(f.format(c.getTime()));
c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
System.out.println(c.get(Calendar.DAY_OF_WEEK));
System.out.println(f.format(c.getTime()));