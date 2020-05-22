JSch jsch = new JSch();
        jsch.setKnownHosts(propertyReader.getKnownHosts());
        session = jsch.getSession(propertyReader.getUsername(),
                propertyReader.getSftpLocation(), 22);
        session.setPassword(propertyReader.getPassword());
        session.connect();
        channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftp = (ChannelSftp) channel;

        if (!StringUtils.isBlank(fileToPut)) {
            sftp.put(fileToPut, propertyReader.getSftpDirectory() + "/"
                    + newFileName);
        } else {
            sftp.put(propertyReader.getSftpDirectory() + "/" + newFileName,
                    ChannelSftp.OVERWRITE);
        }