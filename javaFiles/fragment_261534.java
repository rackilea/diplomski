log.setReceiver(new ISvnObjectReceiver<SVNLogEntry>() {
        @Override
        public void receive(SvnTarget target, SVNLogEntry logEntry) throws SVNException {
            //process logEntry here
        }
    });
    log.run();