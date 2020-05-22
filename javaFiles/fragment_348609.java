JSch jsch = new JSch();
      jsch.setKnownHosts("C:/My Program Files/eclipse/workspace/StatusTracker/known_hosts.txt");
     // jsch.setKnownHosts(knownHostLoc);
      //Jump server connection session started
      jumpServerSession = jsch.getSession(userid, jump server ip/hostname, 22);
      jumpServerSession.setPassword(jump server password);
      java.util.Properties config = new java.util.Properties();
      config.put("StrictHostKeyChecking", "no");
      jumpServerSession.setConfig(config);
      jumpServerSession.connect();
     System.out.println("The session has been established to "+jump server userid+"@"+jump server name);

        int assinged_port = jumpServerSession.setPortForwardingL(0, other server ip, 22);
        System.out.println("portforwarding: "+
                           "localhost:"+assinged_port+" -> "+other server ip+":"+22);
        //Main server connection session started
        targetServerSession =  jsch.getSession(fileBO.getServerUserId(), "127.0.0.1", assinged_port);
        targetServerSession.setHostKeyAlias(other server ip);
        targetServerSession.setPassword(other server password);
        java.util.Properties config1 = new java.util.Properties();
        config1.put("StrictHostKeyChecking", "no");
        targetServerSession.setConfig(config1);
        targetServerSession.connect();


        channel = targetServerSession.openChannel("sftp");
        channel = targetServerSession.openChannel("exec");

//command want to execute on dest server
        ((ChannelExec)channel).setCommand("pwd"); 

          channel.setInputStream(null);
    InputStream in11=channel.getInputStream();
    ((ChannelExec)channel).setErrStream(System.err);   
    channel.connect();
    byte[] tmp1=new byte[1024];
    while(true){
        while(in11.available()>0){
            int i1=in11.read(tmp1, 0, 1024);
            if(i1<0)break;
            System.out.print(new String(tmp1, 0, i1));
        }
        if(channel.isClosed()){
            System.out.println("exit-status: "+channel.getExitStatus());
            break;
        }
        try{Thread.sleep(1000);}catch(Exception ee){}
    }

    } catch (final JSchException e) {
        LOGGER.error(e.getMessage());
    }