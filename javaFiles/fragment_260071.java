public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //..code    
        String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        //..code    
    }
}