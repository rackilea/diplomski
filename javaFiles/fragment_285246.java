public class TerminalController implements Serializable{  

    BufferedReader fromChannel;
    PrintWriter toChannel;
    Channel channel;
    Session session;

     public TerminalController(){
        jsch=new JSch();
        try {
            session=jsch.getSession(user, ip, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(passwd);
            session.connect();
            channel = session.openChannel("shell");    
            InputStream inStream = channel.getInputStream();
            fromChannel = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
            OutputStream outStream = channel.getOutputStream();
            toChannel = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"));
            channel.connect();
        } catch(Exception ee) {
            ee.printStackTrace();
        }
    }

    public String handleCommand(String command, String[] params) {  
         command = command + StringUtils.join(params," ");
         toChannel.println(command);
         StringBuilder result = new StringBuilder();
         while(true) {
            String line = fromChannel.readLine();
            result.append(line);
            if(looksLikePrompt(line))
               return result.toString();
            result.append("\n");
         }
    }
}