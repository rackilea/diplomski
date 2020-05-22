String user = System.getProperty("user.name") + ":";
byte[] encoded_str = Base64.encodeBase64(user
    .getBytes());
String encoded_string = new String(encoded_str)
    .trim();
System.out.println(encoded_string);