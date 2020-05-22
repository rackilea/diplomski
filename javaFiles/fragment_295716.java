public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_place) != null) {


            if (savedInstanceState != null) {
                return;
            }
            SearchLocation fragment = new SearchLocation();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_place, fragment).commit();
        }
    }