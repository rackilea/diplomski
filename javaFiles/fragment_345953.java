public static void main(String args[]) throws JSchException, InterruptedException, IOException {
        JSch objJSch = new JSch();
        Session objSession = objJSch.getSession("userName", "ip_address");
        objSession.setPassword("password");
        objSession.setConfig("StrictHostKeyChecking", "no");
        System.out.println("Establishing Connection...");
        objSession.connect();
        System.out.println("Connection established.");
        Channel objChannel = objSession.openChannel("exec");
        ((ChannelExec) objChannel).setCommand("ps aux");
        InputStream in = objChannel.getInputStream();
        objChannel.connect();
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((s = br.readLine()) != null)
            System.out.println(s);
        System.out.println("disconnecting...");
        objChannel.disconnect();
        objSession.disconnect();
        System.out.println("disconnected.");
}