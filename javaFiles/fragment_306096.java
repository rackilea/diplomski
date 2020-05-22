try {
    FTPClient ftpClient = new FTPClient();
    ftpClient.connect(InetAddress.getByName(Your host Url));
    ftpClient.login(loginName, password);
    System.out.println("status :: " + ftpClient.getStatus());
} catch (Exception e) {
    e.printStackTrace();
}