String myDate="31-JUL-2016"; // notice JUL, instead of JULY
// or use some other date string like yyyy-MM-dd
SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
java.util.Date date = sdf.parse(myDate);
java.sql.Date d = new java.sql.Date(date.getTime());
callableStatement.setDate(parameterName, d);
// here parameterName should be the exact name as 
// in your procedure `pack_context.context_open`.