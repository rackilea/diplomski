public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        ReadJSON classToReadJSON = new ReadJSON();
        classToReadJSON.loadJSONFromAsset(this);
    }
}