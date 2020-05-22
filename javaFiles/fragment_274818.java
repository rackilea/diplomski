public class TestFragment extends Fragment {
    private Handler mHandler;

    /*
     * Skipping most code and I will only show you the most essential.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler();

        startAsyncTask(0);
    }

    private void startAsyncTask(long milisecondsToDelay) {
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                TestAsyncTask testAsyncTask = new TestAsyncTask(new FragmentCallback() {

                    @Override
                    public void onTaskDone() {
                        startAsyncTask(1000);
                    }
                });

                testAsyncTask.execute();
            }
        }, milisecondsToDelay);

    }

    public interface FragmentCallback {
        public void onTaskDone();
    }
}