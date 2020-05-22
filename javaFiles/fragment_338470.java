public class MainClock extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clock);


    }

        public void newPacket(View view) {
            Intent intent = new Intent(this, NewPacket.class);
            startActivity(intent);
        }
}