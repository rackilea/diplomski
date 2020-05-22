abstract class trialmenu extends AppCompatActivity implements asyncResponse {
    private ImageView logo;
    private TextView status;
    AsyncStatus asyncTask = new AsyncStatus();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmenulayout);
        logo = (ImageView) findViewById(R.id.imglogo);
        status = (TextView) findViewById(R.id.txtStatus);
        asyncTask.setDelegete(this);

    }

    @Override
    public void processFinish(String output) {
        // Callback
    }
}