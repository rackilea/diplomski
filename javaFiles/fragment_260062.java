byte[] bytes = ...;

// Requires you to handle UnsupportedEncodingException
String s1 = new String(bytes, "UTF-8");

// Doesn't require you to handle any checked exceptions
String s2 = new String(bytes, Charset.forName("UTF-8"));