public class tutorialpage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorialpage);
        Intent intent = getIntent();
        int topicNumber = intent.getIntExtra(MainActivity.TOPIC_NUMBER,0);
        switch(topicNumber ) {
            case 1:
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.tutView1);
                layout.setVisibility(View.Visible);
                break;
            case 2:
                RelativeLayout layout = (RelativeLayout) findViewById(R.id.tutView2);
                layout.setVisibility(View.Visible);
                break;
        }
    }
    ...
}