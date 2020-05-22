List<Thread> threads = new LinkedList<Thread>();
for (File f : directoryContent) {
    if (f.isDirectory()) {
        DocumentSpider spider = new DocumentSpider(f.getPath(), Spidermode.DIRECTORY, this.resultList);
        spider.terms = this.terms;
        Thread thread = new Thread(spider);
        threads.add(thread)
        thread.start();
    } else {
        DocumentSpider spider = new DocumentSpider(f.getPath(),      Spidermode.FILE, this.resultList);
        spider.terms = this.terms;
        Thread thread = new Thread(spider);
        threads.add(thread)
        thread.start();
    }
}
for (Thread thread: threads) thread.join()