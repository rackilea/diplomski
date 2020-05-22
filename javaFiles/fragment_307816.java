private void uploadFileMFT(String sFTPUser, String sFTPHost, int sFTPPort,
            String sFTPPwd, String sourceLocation, String destinationLocation,
            String uploadedFileName) {

        LOG.info("Inside uploadFileMFT to upload and verify the file.");

        JSch jsch = new JSch();
        Vector<String> fileList = null;

        /** 5 re-attempt logic to get session */
        int attempts = 0;
        boolean successfulConnect;
        do {
            try {
                successfulConnect = true;
                session = jsch.getSession(sFTPUser, sFTPHost, sFTPPort);
                LOG.debug("session connected ...");

                session.setPassword(sFTPPwd);
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);

                session.connect();
                LOG.debug("Sftp Session connected ...");

                channel = session.openChannel("sftp");
                LOG.debug("Sftp Channel opened ...");

                channelSftp = (ChannelSftp) channel;
                channelSftp.connect();
                LOG.info(" Sftp channel opened and connected ...");

                channelSftp.put(sourceLocation, destinationLocation);

                fileList = channelSftp.ls(destinationLocation);

            } catch (JSchException e) {
                ++attempts;
                successfulConnect = false;
                LOG.error(e);
            } catch (SftpException e) {
                ++attempts;
                successfulConnect = false;
                LOG.error(e);
            } finally {
                if (null != channelSftp) {
                    channelSftp.exit();
                    LOG.debug(" sftp Channel exited.");
                }

                if (null != channel) {
                    channel.disconnect();
                    LOG.debug(" Channel disconnected.");
                }

                if (null != session) {
                    session.disconnect();
                    LOG.debug(" Host Session disconnected.");
                }
            }
        } while (attempts < 5 && successfulConnect == false);

        fileUploadValidation(fileList, uploadedFileName);

        LOG.info("Exiting from method - uploadFileMFT ...");
    }