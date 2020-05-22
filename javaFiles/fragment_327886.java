// Setup our SFTP configuration
FileSystemOptions opts = new FileSystemOptions();
SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);
SftpFileSystemConfigBuilder.getInstance().setPreferredAuthentications(opts, "publickey,keyboard-interactive,password");