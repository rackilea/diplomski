try {
        String filePath = "myserver/dir";
        String fileName = "myFile.txt";
        String user = "username";
        String password = "password";
        // URL: smb://user:passwd@host/share/filname
        SmbFileOutputStream out = new SmbFileOutputStream("smb://" + user + ":" + password + "@" + filePath
                + File.separator + fileName);
        out.write("test".getBytes());
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }