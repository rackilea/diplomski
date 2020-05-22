String item = request.getParameter("param"); 

byte[] bytes = item.getBytes(StandardCharsets.ISO_8859_1);
item = new String(bytes, StandardCharsets.UTF_8);

// Java 6:
// byte[] bytes = item.getBytes("ISO-8859-1");
// item = new String(bytes, "UTF-8");