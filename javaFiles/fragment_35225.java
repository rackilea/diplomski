String date = "30/06/2014";
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Calendar c = Calendar.getInstance();
c.setTime(sdf.parse(date));
c.add(Calendar.DATE, +2);
System.out.println(sdf.format(c.getTime()));