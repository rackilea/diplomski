public void syncDB() {

  new Thread() {

    public void run() {

      ia.showInfo("Sync cat...");
      doCatSync();

      ia.showInfo("Sync item...");
      doItemSync();
      ...
    }
  }.start();
}