class CrawlerTask extends Runnable {
   URL url;

   CrawlerTask(URL url) { this.url = url; }

   @Override
   public void run() {
     scrape(url);
     // add url to visited?
   }
}

class Crawler {
  ExecutorService executor;
  Queue urlHorizon;

  //...

  private static void startCrawling() {
    while (!urlHorizon.isEmpty()) {
      executor.submit(new CrawlerTask(urlHorizon.poll());
    }
    // ...
  }
}