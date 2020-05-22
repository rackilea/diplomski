public List<String> sendCommand(String command) throws JSchException, IOException {
        List<String> lines = new LinkedList<String>();
        Channel channel = sesConnection.openChannel("exec");
        ((ChannelExec) channel).setCommand(command);
        channel.connect();

        InputStream commandOutput = channel.getInputStream();
        result = new BufferedReader(new InputStreamReader(commandOutput));            
        String line = null;

        while ((line = result.readLine()) != null) {
           lines.add(line);
        }

        channel.disconnect();
        return lines;        
}