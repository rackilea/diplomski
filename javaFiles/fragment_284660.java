String[] Parameter = { "user1", "Administrator" };
String query = "select * from userinfo where firstname in (";
String temp = "";

for(i = 0; i < Parameter.length; i++) {
  temp += ",?";
}

temp = temp.replaceFirst(",", "");
temp += ")";
query = query + temp;

PreparedStatement pst = conn.prepareStatement(query);