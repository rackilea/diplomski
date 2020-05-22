String sql="select message_id, sent from messages";
Messages msg=new Messages();
Calendar cal=Calendar.getInstance();   
java.util.Date d=rs.getTimestamp("sent");  
String pattern = "yyyy-MM-dd hh:mm:ss a";
SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
String conDate=simpleDateFormat.format(d);