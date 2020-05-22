public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public class MonitorObject{
        }
        final MonitorObject mSync = new MonitorObject();
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);

            TextView txt = (TextView) rootView.findViewById(R.id.textview1);
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    synchronized (mSync) {
                         mSync.notify();

                }
            });    

            LoopTask taskA = new LoopTask();
            Thread a = new Thread(taskA);
            a.start();
            return rootView;
        }

        class LoopTask implements Runnable {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    synchronized (mSync) {
                        try {
                            mSync.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    final int runNumber = i; 
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "inside the thread1 " + runNumber , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }

    }
}