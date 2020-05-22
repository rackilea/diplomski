String pattern = "<yourPattern>";
SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
try {
 Date one = dateFormat.parse(<yourDate>);
 Date two = dateFormat.parse(<yourDate>);

}
catch (ParseException e) {}