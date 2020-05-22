try {
            Thread.sleep(RetrySleep);
            logger.debug("retrying connection");
            ftp = ftpConnection(in, objGetFiles);

        } catch (InterruptedException iex) {
            logger.debug(iex.toString());
        }