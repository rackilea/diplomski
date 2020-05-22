public class MainActivity extends AppCompatActivity {

    public int cont = 0;
    private TextView campoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = findViewById(R.id.mytextview);

        Timer timer = new Timer();
        Handler mainHandler = new Handler(getBaseContext().getMainLooper());

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mainHandler.post(MainActivity.this::update);
            }
        };
        timer.scheduleAtFixedRate(task, 100, 1000);
    }

    @MainThread
    public void update() {
        campoTexto.setText(String.valueOf(cont));
        cont++;
    }
}