FTPClient ftp = new FTPClient();

try {
    ftp.connect("somehost");
    ftp.login("user", "pw");
    ftp.enterLocalPassiveMode();

    OutputStream out = ftp.storeFileStream("dump1");
    if (out == null) {
        System.out.println(ftp.getReplyCode());
        System.out.println (ftp.getReplyString());
        return;
    }
    out.write("test is a test".getBytes());
    out.flush();
    out.close();
    System.out.println (ftp.getReplyString());
    ftp.completePendingCommand();
    System.out.println (ftp.getReplyString());

    out = ftp.storeFileStream("dump2");
    if (out == null) {
        System.out.println(ftp.getReplyCode());
        System.out.println (ftp.getReplyString());
        return;
    }
    out.write("test is a test2".getBytes());
    out.flush();
    out.close();
    System.out.println (ftp.getReplyString());
    ftp.completePendingCommand();
    System.out.println (ftp.getReplyString());

} catch (IOException e) {
    e.printStackTrace();
}
    finally {
        try {
            ftp.disconnect();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }