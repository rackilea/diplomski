java.util.Date date1= new java.util.Date();

Time Sqldob1 = new Time(date1.getTime());
System.out.println("User Time: " +Sqldob1);

Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 19); // Your hour
cal.set(Calendar.MINUTE, 30); // Your Mintue
cal.set(Calendar.SECOND, 00); // Your second

Time sqlTime3 = new Time(cal.getTime().getTime());
System.out.println("your time: "+sqlTime3);

if(Sqldob1.before(sqlTime3)){
   Sqldob1 = sqlTime3; 
   System.out.println("inside loop");
}