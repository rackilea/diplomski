String command1 = "cd /home/jan; ./test.sh";
try {
    java.util.Properties config = new java.util.Properties();
    config.put("StrictHostKeyChecking", "no");
    JSch jsch = new JSch();
    Session session = jsch.getSession(user, host, 22);
    session.setPassword(password);
    session.setConfig(config);
    session.connect();
    System.out.println("Connected");
    ChannelExec channel = (ChannelExec)session.openChannel("exec");
    OutputStream o = channel.getOutputStream();
    PrintWriter pw = new PrintWriter(o);
    InputStream in = channel.getInputStream();
    ((ChannelExec) channel).setCommand(command1);

    channel.connect();

    // 1 - Reading the prompt to input password
    byte[] buf = new byte[255];
    int len = in.read(buf);
    System.out.println(new String(buf,0,len));

    // 2 - Send (password) data and flush stream
    pw.println("y");
    pw.flush();

    // 3 - Read result
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    System.out.println(br.readLine());

    // 4 - Clean up
    channel.disconnect();
    session.disconnect();