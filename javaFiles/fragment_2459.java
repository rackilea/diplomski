public void syncDB() {

  ia.showInfo("Sync cat...");
  doCatSync();

  ia.showInfo("Sync item...");
  doItemSync();
  ...
}