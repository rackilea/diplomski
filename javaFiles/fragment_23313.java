public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new LinearLayout(this);
        setContentView(layout);
        Updater updater = new Updater(new WorkerThreadListener() {
            @Override
            public void onUpdate(int counter) {
                //update layout here
            }
        });
        Thread workerThread = new Thread(updater);
        workerThread.start();
    }
}