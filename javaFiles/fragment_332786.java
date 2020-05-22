public class OnlineGameActivity extends Activity {

    Handler myHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {

                case 0:
                   ...
                   break;

                ...
            }
        }
    }

    public OnlineGameActivity(...) {
        ...

        YourAsyncTask task = new YourAsyncTask(myHandler);
        task.execute();
    }
}