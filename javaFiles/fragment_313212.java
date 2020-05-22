ChannelExec channel = (ChannelExec)session.openChannel("exec");

channel.setCommand(
    "for((i=1;i<=10000;i+=2)); do echo \"Long output - $i\"; done ; " +
    "echo error output >&2");
InputStream commandOutput = channel.getExtInputStream();

StringBuilder outputBuffer = new StringBuilder();
StringBuilder errorBuffer = new StringBuilder();

InputStream in = channel.getInputStream();
InputStream err = channel.getExtInputStream();

channel.connect();

byte[] tmp = new byte[1024];
while (true) {
    while (in.available() > 0) {
        int i = in.read(tmp, 0, 1024);
        if (i < 0) break;
        outputBuffer.append(new String(tmp, 0, i));
    }
    while (err.available() > 0) {
        int i = err.read(tmp, 0, 1024);
        if (i < 0) break;
        errorBuffer.append(new String(tmp, 0, i));
    }
    if (channel.isClosed()) {
        if ((in.available() > 0) || (err.available() > 0)) continue; 
        System.out.println("exit-status: " + channel.getExitStatus());
        break;
    }
    try { 
      Thread.sleep(1000);
    } catch (Exception ee) {
    }
}

System.out.println("output: " + outputBuffer.toString());
System.out.println("error: " + errorBuffer.toString());

channel.disconnect();