JSONObject json = new JSONObject(StringResponse);

String FirstName = json.getString("FirstName");
String LastName = json.getString("LastName");
String ID = json.getString("ID");
String Cell= json.getString("Cell");
String Email= json.getString("Email");