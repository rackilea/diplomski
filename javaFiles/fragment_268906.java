Downloader dlA = new Downloader(...);
Downloader dlB = new Downloader(...);

ProgressListener listener = new ProgressListener() {
  @Override
  public void onProgress(int n) {
    dlA.removeListener(this);
    dlB.removeListener(this);
  }
}

dlA.addListener(listener);
dlB.addListener(listener);