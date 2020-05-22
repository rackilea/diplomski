Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
            try {
            String shutdownurl = "http://localhost:" + resultPortNo + "/api/shutdown";
            URL url = new URL(shutdownurl);
            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            try {
               connection.getResponseCode();
               connection.disconnect();
            } catch (SocketException e) {
               // logger.debug("Not running");
               // Okay - the server is not running
               connection.disconnect();
          }
        } catch (Exception x) {
        // exception during shutdown
        Activator.error("Unable to shutdown Jetty Server.\n" + x.getMessage());
                }
            }
        });