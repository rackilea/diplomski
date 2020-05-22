java.util.Date utilDate = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(utilDate);
cal.set(Calendar.MILLISECOND, 0);
System.out.println(new java.sql.Timestamp(utilDate.getTime()));
System.out.println(new java.sql.Timestamp(cal.getTimeInMillis()));