public class FileFilterTest {
        public static void main(String[] args) {
            File dir = new File("D:\\dev\\css-templates\\cms-admin");
            BlockingQueue blockingQueue = new ArrayBlockingQueue(5);
            FileCrawler fileCrawler = new FileCrawler(blockingQueue,
                    new ImageFileFilter(), dir);
            new Thread(fileCrawler).start();

            FileIndexer indexer = new FileIndexer(blockingQueue);
            new Thread(indexer).start();
        }
    }