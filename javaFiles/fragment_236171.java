Calendar c = Calendar.getInstance();
 c.set(2015, 0, 31);
 c.SimpleDateFormat df= new SimpleDateFormat("dd-MMM-yyyy");
 System.out.println(df.format(c.getTime()));
 c.add(Calendar.DATE,1);
 System.out.println(df.format(c.getTime()));