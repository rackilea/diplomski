class MyWorker extends org.niocchi.gc.DiskSaveWorker {

    Crawler mCrawler = null;
    ExpandableURLPool pool = null;

    int maxepansion = 10;

    public MyWorker(Crawler crawler, String savePath, ExpandableURLPool aPool) {
        super(crawler, savePath);
        mCrawler = crawler;
        pool = aPool;
    }

    @Override
    public void processResource(Query query) {
        super.processResource(query);
        // The following is a test
        if (--maxepansion >= 0  ) {
            pool.addURL("http://www.somewhere.com");
        }       

    }


}