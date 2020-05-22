class VolatileTest implements Runnable
{
        // try with and without volatile
        private volatile boolean stopRunning = false;

        public void triggerStop(){
             stopRunning = true;
        }

        @Override
        public void run(){
             while(!stopRunning);
             System.out.println("Finished.");
        }

        public static void main (String[] args) throws java.lang.Exception
        {
            final VolatileTest test = new VolatileTest();
            new Thread(test).start();
            Thread.sleep(1000);
            test.triggerStop() = false;
        }
}