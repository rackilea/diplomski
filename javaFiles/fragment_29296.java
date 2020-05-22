Date now = new Date();

Calendar cal = Calendar.getInstance();
cal.add(Calendar.DATE, -1);
System.out.println(now + " isBefore " + cal.getTime() + " = " + now.before(cal.getTime()));
System.out.println(now + " isAfter " + cal.getTime() + " = " + now.after(cal.getTime()));
cal.add(Calendar.DATE, 2);
System.out.println(now + " isBefore " + cal.getTime() + " = " + now.before(cal.getTime()));
System.out.println(now + " isAfter " + cal.getTime() + " = " + now.after(cal.getTime()));