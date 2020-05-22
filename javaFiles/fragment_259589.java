public class FTPDownloadFileDemo {
    public static void main(String args[]) {

        String hostname = "XXX";
        String username = "XXX";
        String password = "XXX";
        //Single file download
        //  String copyFrom = "serverFolderPath/";
        //  String copyTo = "localPath/";       
        JSch jsch = new JSch();
        Session session = null;
        System.out.println("Trying to connect.....");
        try {
            session = jsch.getSession(username, hostname, 22);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");

            session.setConfig(config);
            session.setPassword(password);
            session.connect(); 
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel; 

            sftpChannel.cd("serverFolderPath/csv/");
            Vector<ChannelSftp.LsEntry> list = sftpChannel.ls("*");
            for(ChannelSftp.LsEntry entry : list) {
                 System.out.println("Name :"+entry.getFilename()); 
            }
           //  sftpChannel.get(copyFrom, copyTo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }
        System.out.println("Done !!");
    }
}