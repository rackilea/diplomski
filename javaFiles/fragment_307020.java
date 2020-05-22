FTPClient ftpClient = new FTPClient();
ftpClient.connect(InetAddress.getByName(server));
ftpClient.login(user, password);
ftpClient.changeWorkingDirectory(serverRoad);
ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

BufferedInputStream buffIn = null;
buffIn = new BufferedInputStream(new FileInputStream(file));
ftpClient.enterLocalPassiveMode();
ftpClient.storeFile("test.txt", buffIn);
buffIn.close();
ftpClient.logout();
ftpClient.disconnect();