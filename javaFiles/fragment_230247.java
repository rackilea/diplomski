InputStream in = new PipedInputStream();
PipedOutputStream pin = new PipedOutputStream((PipedInputStream) in);
/**...*/
channel.setInputStream(in);
channel.connect();
/** ...*/
pin.write(myScript.getBytes());