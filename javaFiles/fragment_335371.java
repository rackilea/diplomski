Calendar calendar = Calendar.getInstance();
Timestamp ts =  new java.sql.Timestamp(calendar.getTime().getTime());
String mydate = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(ts);
ArrayList<Object> values = new ArrayList<Object>();

values.add(0, mydate);