public class FileIndexer implements Runnable {
        private final BlockingQueue queue;

        public FileIndexer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() { 
            try {
                while (true) {
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                System.out.println("Indexer Interrupted");
                Thread.currentThread().interrupt();
            }
        }

        public void indexFile(File file) {
            // do something with the file...
            System.out.println("Indexing File : " + file.getAbsolutePath() + " " + file.getName());
        };
    }