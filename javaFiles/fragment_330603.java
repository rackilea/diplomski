Channel channel = session.openChannel("shell");
    cmdSend = channel.getOutputStream();
    InputStream cmdRcv = channel.getInputStream();
    // Start a Thread reading and displaying cmdRcv

    channel.connect(3000);
    Thread.sleep(1000);

    cmdSend.write("cd /to/the/right/dir\n".getBytes());
    cmdSend.flush();
    cmdSend.write("sh process.ksh \"a.txt\"\n".getBytes());
    cmdSend.flush();