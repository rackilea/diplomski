try {
      jettyServer.start();
      jettyServer.join();
    } catch (Exception e){
        logger.errror("error during server starting",e)
        jettyServer.stop();
        jettyServer.destroy();
    }