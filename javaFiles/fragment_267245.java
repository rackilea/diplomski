SocketAppender socketAppender = new SocketAppender(server, port);
        socketAppender.setReconnectionDelay(60000);
        socketAppender.setThreshold(Level.DEBUG);
        socketAppender.setName("server-socket");
        socketAppender.addFilter(new Filter() {
            @Override
            public int decide(LoggingEvent loggingEvent)
            {
                if(ignoreLogsFromClasses.contains(loggingEvent.categoryName))
                {
                    return -1;
                }
                return 0;
            }
        });
        rootLogger.addAppender(socketAppender);