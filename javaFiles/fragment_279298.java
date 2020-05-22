System.out.println("Start get From Socket           "
        + System.currentTimeMillis());
InputStream mis = socket.getInputStream();
byte[] buffer = new byte[8192];
// Read all the data (but ignore it)
while ((mis.read(buffer)) != -1) ;
System.out.println("Stop get From Socket           "
        + System.currentTimeMillis());