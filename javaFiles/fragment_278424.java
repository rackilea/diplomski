public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // starting your Service
        startTheService();
    }

    public void startTheService() {
        Intent intent = new Intent(this, WLANService.class);
        intent.putExtra("message", "I got your message!");
        startService(intent);
    }
}