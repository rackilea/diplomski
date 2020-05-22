public void cmremove()
{
    try
    {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        UserInfo ui = new SUserInfo(pass, null);
        session.setUserInfo(ui);
        session.setPassword(pass);
        session.connect();

        ChannelExec channelExec = (ChannelExec)session.openChannel("exec");

        InputStream in = channelExec.getInputStream();

        channelExec.setCommand("./repoUpdate.sh");
        channelExec.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        int index = 0;

        while ((line = reader.readLine()) != null)
        {
            System.out.println(++index + " : " + line);
        }

        int exitStatus = channelExec.getExitStatus();
        channelExec.disconnect();
        session.disconnect();
        if(exitStatus < 0){
            System.out.println("Done, but exit status not set!");
        }
        else if(exitStatus > 0){
            System.out.println("Done, but with error!");
        }
        else{
            System.out.println("Done!");
        }
    }
    catch(Exception e)
    {
        System.err.println("Error: " + e);
    }
}