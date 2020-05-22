public static FacebookController getController() {
    synchronized (lock) {
      if (controller == null) {
        controller = new FacebookController();
      }
      return controller;
    }
  }