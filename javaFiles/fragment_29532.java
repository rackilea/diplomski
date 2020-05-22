public class MyHandler {

        @Override
        public void handleMessage(Message inputMessage) {
            int messageType = inputMessage.what;
            Object extraData = inputMessage.obj;
            ...
        }
  }

  public class MyTask extends Thread {
       public static public int COMPUTATION_DONE = 0;
       private MyHandler handler;

       public MyTask(MyHandler handler) {
            this.handler = handler;
       }

        @Override
        public void run() {
            //do your computation
            Message message = handler.obtainMessage(COMPUTATION_DONE, your_result);
            handler.sendMessage(message);
        }
  }