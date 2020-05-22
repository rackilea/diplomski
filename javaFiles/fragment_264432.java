import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Logger extends Thread{
        private static Logger logger = null;
        private BlockingQueue<String> logRequests;

        private Logger(){
            logRequests = new ArrayBlockingQueue<String>(10000);
        }

        public static Logger getLogger(){
            if(logger == null){
                synchronized (Logger.class) {
                    logger = new Logger();
                    logger.start();
                }
            }
            return logger;
        }


        @Override
        public void run() {
            System.out.println("Starting to log");
            while(true){
                try {
                    System.out.println(logRequests.take());
                } catch (InterruptedException e) {
                    //interrupted so stop logging
                    System.out.println("Logger exiting");
                    break;
                }
            }
        }

        public void info(String logMessage){
            //not taken care of the case when queue becomes full
            //will leave it to you
            logRequests.add(logMessage);
        }
    }