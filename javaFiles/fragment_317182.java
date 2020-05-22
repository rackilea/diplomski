public class TwitterStreamConsumer  implements Runnable{

    private final BlockingQueue<Pair<String, QueryResult>> tweetBuffer;
    private final ResultsController resultsController;
    private String name=null;
    private boolean stopped;

    public TwitterStreamConsumer(String name, BlockingQueue<Pair<String, QueryResult>> tweetBuffer) {

        this.name=name;
        this.tweetBuffer=tweetBuffer;
        this.resultsController=new ResultsController();
    }

    public void stop() {
        stopped = true;
    }

    public void run() {
        stopped = false;


        while(! stopped) {
            try {
                resultsController.parse(this.tweetBuffer.take());
                Logger.getLogger("TwitterApp").info(this.name+" has consummed queue, current size of queue:"+tweetBuffer.size());
            }
            catch (InterruptedException e) {
                Logger.getLogger("Consumer").info(this.name+ " interrupted "+e.getMessage());
            }
        }
    }
}