String server = "www.myserver.com";
    int port = 21;
    String user = "user";
    String pass = "pass";

    FTPClient ftpClient = new FTPClient();

    ftpClient.connect(server, port);
    ftpClient.login(user, pass);
    InputStream inputStream = ftpClient.retrieveFileStream("/test/test1.txt");