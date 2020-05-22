public static void main(String[] args) {
    FTPSClient ftp = new FTPSClient();
    String host = "server.com";
    int port = 2121;
    String folderName = "dir";
    String username = "user";
    String password = "password";
    try {
        ftp.connect(host, port);
        ftp.login(username, password);
        InputStream fis = new FileInputStream("../filename_src.txt");

        ftp.storeFile("/" + folderName + "/filename_dest.xml", fis);
        fis.close();

        ftp.logout();
        ftp.disconnect();
    } catch (SocketException ex) {
        Logger.getLogger(FTPSendMessage.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(FTPSendMessage.class.getName()).log(Level.SEVERE, null, ex);
    }
}