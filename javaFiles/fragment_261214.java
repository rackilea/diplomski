ChannelShell shellChannel = (ChannelShell) session.openChannel("shell");
shellChannel.setOutputStream(outputStream, true);
InputStream in = new PipedInputStream();
PipedOutputStream pin = new PipedOutputStream((PipedInputStream) in);
shellChannel.setInputStream(in);
shellChannel.connect();
pin.write("ls \r").getBytes());