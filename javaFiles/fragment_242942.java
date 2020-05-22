...
    java.util.Properties config = new java.util.Properties();
    config.put("StrictHostKeyChecking", "no");

    JSch ssh = new JSch();
    session = ssh.getSession(sshSolrUsername, sshSolrHost, 22);
    session.setConfig(config);
    session.setPassword(sshSolrPassword);
    session.connect();
    channel = session.openChannel("exec");        
    ((ChannelExec)channel ).setCommand("cd " + sourcePath);     
    exec.setInputStream(null);
    ((ChannelExec)channel ).setErrStream(System.err);
    InputStream in = channel .getInputStream();
    channel .connect();
    int status = checkStatus(channel , in);
    channel.disconnect();
    ...