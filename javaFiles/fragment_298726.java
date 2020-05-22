public class DownloadResult {

  protected final URL url; // this is for convenience
  protected boolean inProgress;
  protected byte[] result;

  public DownloadResult(final URL url) {
    this.url = url;
    this.inProgress = false;
  }

  /* Try to lock this against tother threads if not already acquired. */
  public synchronized boolean acquire() {
    if (this.inProgress == false) {
      this.inProgress = true;
      return true;
    } else {
      return false;
    }
  }

  public void download() {
    final byte[] downloadedBytes = Util.download(this.url); // note how this is done outside the synchronized block to avoid unnecessarily long blockings
    synchronized (this) {
      this.result = downloadedBytes;
      this.notifyAll(); // wake-up ALL callers
    }
  }

  public synchronized byte[] getResult() throws InterruptedException {
    while (this.result == null) {
      this.wait();
    }
    return this.result;
  }

}

protected class DownTh extends Thread {

  protected final Map<URL, DownloadResult> urlData;

  public DownTh(final Map<URL, DownloadResult> urlData) {
    this.urlData = urlData;
    this.setDaemon(true); // this allows the JVM to shut down despite DownTh threads still running
  }

  protected DownloadResult getTask() {
    for (final DownloadResult downloadResult : urlData.values()) {
      if (downloadResult.acquire()) {
        return downloadResult;
      }
    }
    return null;
  }

  @Override
  public void run() {
    DownloadResult downloadResult;
    try {
      while (true) {
        synchronized (urlData) {
          while ((downloadResult = this.getTask()) == null) {
            urlData.wait();
          }
        }
        downloadResult.download();
      }
    } catch (InterruptedException ex) {
      // can be ignored
    } catch (Error e) {
      // log here
    }
  }
}

public class Downloader {

  protected final Map<URL, DownloadResult> urlData = new HashMap<>();

  // insert constructor that creates the threads here

  public DownloadResult download(final URL url) {
    final DownloadResult result = new DownloadResult(url);
    synchronized (urlData) {
      urlData.putIfAbsent(url, result);
      urlData.notify(); // only one thread needs to wake up
    }
    return result;
  }

  public byte[] getData(final URL url) throws InterruptedException {
    DownloadResult result;
    synchronized (urlData) {
      result = urlData.get(url);
    }
    if (result != null) {
      return result.getResult();
    } else {
      throw new IllegalStateException("URL " + url + " not requested.");
    }
  }
}