Calendar c=Calendar.getInstance();
c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
c.set(Calendar.HOUR_OF_DAY,0);
c.set(Calendar.MINUTE,0);
c.set(Calendar.SECOND,0);
DateFormat df=new SimpleDateFormat("EEE yyyy/MM/dd HH:mm:ss");
System.out.println(df.format(c.getTime()));      // This past Sunday [ May include today ]
c.add(Calendar.DATE,7);
System.out.println(df.format(c.getTime()));      // Next Sunday
c.add(Calendar.DATE,7);
System.out.println(df.format(c.getTime()));      // Sunday after next