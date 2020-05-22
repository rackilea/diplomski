private String user = "root",
            newPassword = "test123";

private int port = 22;

public SSHConnection(String host, String password) {
     try {
        JSch jsch = new JSch();

        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelExec channel = (ChannelExec)session.openChannel("exec");
        OutputStream out = channel.getOutputStream();

        ((ChannelExec)channel).setErrStream(System.err);
        channel.setPty(true);
        channel.connect();

        out.write((password + "\n").getBytes());
        out.flush();
        Thread.sleep(1000);

        out.write((newPassword + "\n").getBytes());
        out.flush();
        Thread.sleep(1000);

        out.write((newPassword + "\n").getBytes());
        out.flush();
        Thread.sleep(1000);

        channel.disconnect();
        session.disconnect();
    }
    catch(Exception e) {
        e.printStackTrace();
    }
}