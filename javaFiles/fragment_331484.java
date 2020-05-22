applicationContext
            .findBean(EmbeddedServer.class)
            .ifPresent(server -> {
                // start server
                long start = System.currentTimeMillis();
                server.start();
             });