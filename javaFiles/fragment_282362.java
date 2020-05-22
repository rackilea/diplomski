String baseURL="https://sb-ssl.google.com/safebrowsing/api/lookup";

String arguments = "";
arguments + =URLEncoder.encode("client", "UTF-8") + "=" + URLEncoder.encode("myapp", "UTF-8") + "&";
arguments + =URLEncoder.encode("apikey", "UTF-8") + "=" + URLEncoder.encode("12341234", "UTF-8") + "&";
arguments + =URLEncoder.encode("appver", "UTF-8") + "=" + URLEncoder.encode("1.5.2", "UTF-8") + "&";
arguments + =URLEncoder.encode("pver", "UTF-8") + "=" + URLEncoder.encode("3.0", "UTF-8");

// Construct the url object representing cgi script
URL url = new URL(baseURL + "?" + arguments);

// Get a URLConnection object, to write to POST method
URLConnection connect = url.openConnection();

// Specify connection settings
connect.setDoInput(true);
connect.setDoOutput(true);

// Get an output stream for writing
OutputStream output = connect.getOutputStream();
PrintStream pout = new PrintStream (output);
pout.print("2");
pout.println();
pout.print("http://www.google.com");
pout.println();
pout.print("http://www.facebook.com");
pout.close();