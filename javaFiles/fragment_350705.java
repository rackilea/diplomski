server = new Server();
        if (log.isTraceEnabled()) {
            server.setSilent(false);
            server.setTrace(true);
        } else {
            server.setLogWriter(null);
            server.setSilent(true);
            server.setTrace(false);
        }