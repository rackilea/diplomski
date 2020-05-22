public class ModelFragment extends Fragment implements Handler.Callback {

   Handler backHandler1, backHandler2, mainHandler;

   @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        HandlerThread backThread1 = new HandlerThread("BACK_THREAD_1");
        backThread1.start();
        backHandler1 = new Handler(backThread1.getLooper(), this);

        HandlerThread backThread2 = new HandlerThread("BACK_THREAD_2");
        backThread2.start();
        backHandler2 = new Handler(backThread2.getLooper(), this);

        mainHandler = new Handler(Looper.getMainLooper(), this);
        // sending message from main thread to thread 1
        backHandler1.obtainMessage(BACK1_WHAT, backObj).sendToTarget();
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch(msg.what){
            case BACK1_WHAT:
            // this code runs on thread 1

            // sending message to thread 2 from thread 1
            backHandler2.obtainMessage(BACK2_WHAT, backObj1).sendToTarget();
            return true;

            case BACK2_WHAT:
            // this code runs on thread 2

            // sending message to thread 1 from thread 2
            backHandler1.obtainMessage(BACK1_WHAT, backObj2).sendToTarget();

            // sending message to main thread from thread 2
            mainHandler.obtainMessage(MAIN_WHAT, backObj2).sendToTarget();
            return true;

            case MAIN_WHAT:
            // runs on ui thread
            return true;
        }
        return false;
    }

    @Override
    public void onDestroy() {
       if(null != backHandler1) {
           backHandler1.removeCallbacksAndMessages(null);
           if(null != backHandler1.getLooper())
               backHandler1.getLooper().quit();
       }
       if(null != backHandler2) {
           backHandler2.removeCallbacksAndMessages(null);
           if(null != backHandler2.getLooper())
               backHandler2.getLooper().quit();
       }
       super.onDestroy();
   }
}