public class ConsumeRunner implements Runnable{

        String lastSourceOffset;
        int maxBatchSize;
        BatchMaker batchMaker;
        public ConsumeRunner(String lastSourceOffset, int maxBatchSize, BatchMaker batchMaker)
        {
            this.lastSourceOffset=lastSourceOffset;
            this.maxBatchSize=maxBatchSize;
            this.batchMaker=batchMaker;
        }

        @Override
        public void run() {
            consume(lastSourceOffset,  maxBatchSize, batchMaker);

        }
    }