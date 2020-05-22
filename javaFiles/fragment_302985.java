DateFormat dateFormat = new SimpleDateFormat("M/d/yy");

PreparedStatement stmt = con.prepareStatement("replace into records"
   + " (date_record, hour, IdSensor, Temp, Hum, dew_point) values (?,?,?,?,?,?)");

stmt.setDate(1, new java.sql.Date(dateFormat.parse(data[0]).getTime()));
stmt.setInt(2, data[1]);
// etc...

stmt.executeUpdate();