while (true) {

    try {

      _server.ping();
      // If control reaches here we were able to successfully ping the job monitor.

    } catch (Exception e) {

      System.out.println("Job lost contact with the job monitor at " + new Date().toString() + " ...");

      // If control reaches we were unable to ping the job monitor.  Now we will loop until it presumably comes back to life.
      boolean foundServer = false;
      while (!foundServer) {

        try {

          // Attempt to register again.
          Registry registry = LocateRegistry.getRegistry(_hostName, _port);
          registry.rebind(_bindedClientName, NiceSupervisor.this);
          Remote remoteServer = registry.lookup(_masterName);
          _server = (NiceRemoteJobMonitor)remoteServer;
          _server.registerClient(_bindedClientName, _jobStateSummary);

          // Ping the server for good measure.
          _server.ping();

          System.out.println("Job reconnected with the job monitor at " + new Date().toString() + " ...");

          // If control reaches here we were able to reconnect to the job monitor and ping it again.
          foundServer = true;

        } catch (Exception x) {

          System.out.println("Job still cannot contact the job monitor at " + new Date().toString() + " ...");

        }

       // Sleep for 1 minute before we try to locate the registry again.
        try {
          Thread.currentThread().sleep(PING_WAIT_TIME);
        } catch (InterruptedException x) {

        }

     } // End of endless loop until we find the server again.

   }

    // Sleep for 1 minute after we ping the server before we try again.
    try {
      Thread.currentThread().sleep(PING_WAIT_TIME);
    } catch (InterruptedException e) {

    }

  }  // End of endless loop that we never exit.