HttpUrlConnection connection = // initialize me!
connection.setReadTimeout(TIMEOUT_VALUE);
SOAPMessage sm = // initialize me!

// more stuff for your message

connection.connect();

sm.writeTo(connection.getOutputStream());