private Ftps sendWithFtpsJSCAPE(ConnDetails details, InputStream stream, String filename) throws FtpException, IOException {
    Ftps ftp;
    FtpConnectionDetails ftpDetails = FtpConnectionDetails details;

    ftp = new Ftps(ftpDetails.getHost(), ftpDetails.getUsername(), ftpDetails.getPassword());



    if (ftpDetails.getSecurityMode().equals(FtpConnectionDetails.SecurityMode.EXPLICIT)) {
        ftp.setConnectionType(Ftps.AUTH_TLS);
    } else {
        ftp.setConnectionType(Ftps.IMPLICIT_SSL);
    }
    ftp.setPort(ftpDetails.getPort());

    if (!ftpDetails.getFtpMode().equals(FtpMode.ACTIVE)) {
        ftp.setPassive(true);
    }
    ftp.setTimeout(FTPS_JSCAPE_TIME_OUT);
    ftp.connect();
    ftp.setBinary();
    ftp.setDir(ftpDetails.getPath());
    ftp.upload(stream, filename);

    return ftp;
}