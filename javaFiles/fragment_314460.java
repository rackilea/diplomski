System.out.println("Result fromssh.authenticate(pwd) " + result);
    // Evaluate the result
    if (result == AuthenticationProtocolState.COMPLETE) {
        SftpSubsystemClient sftpSubsystemClient = ssh.openSftpChannel();
        com.sshtools.j2ssh.connection.Channel sftpChannel = sftpSubsystemClient;
        System.out.println("Local packet size: " + sftpChannel.getLocalPacketSize());
        System.out.println("Remote packet size: " + sftpChannel.getRemotePacketSize());

        SftpFile file = sftpSubsystemClient.openFile(remoteFile, SftpSubsystemClient.OPEN_CREATE | SftpSubsystemClient.OPEN_WRITE);

        FileAttributes attrs = file.getAttributes();
        attrs.setPermissions("rwxrwxrwx");
        sftpSubsystemClient.setAttributes(file, attrs);

        final int bufferSize = 4096;
        System.out.println("Creating buffered streams");
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(localFile), bufferSize);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new SftpFileOutputStream(file)));

        int c;            
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        System.out.println("Done writing streams");
        out.close();
        in.close();
        sftpSubsystemClient.close();            
        ssh.disconnect();
    }
    System.out.println(" END ");