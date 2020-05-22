FileInputStream fis = null;
int size = (int)f.length();
byte[] bytes = new byte[size];
fis = new FileInputStream( f );
int read = fis.read( bytes );

connectionSocket.getOutputStream().write( bytes );
connectionSocket.getOutputStream().flush();