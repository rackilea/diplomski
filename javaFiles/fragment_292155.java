String server = "xxxxxxx";
        String username = "xxxxxx";
        String password = "xxxxxx";
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
        try {
            client.connect(server);
            client.login(username, password);
            client.enterLocalPassiveMode();
            client.setFileType(FTP.BINARY_FILE_TYPE);

            fis = new FileInputStream(localfile);

            client.storeFile(destinationfile, fis);
            fis.close();
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }