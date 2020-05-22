public class MainActivity extends AppCompatActivity {

    //Declare this global String for use with Intent extra key
    public static final String TOPIC_NUMBER= "topic_number";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayTutorial(View view) {
        Intent intent = new Intent(this, tutorialpage.class);
        switch(view.getId()) {
            case R.id.chapter1:
                intent.putExtra(TOPIC_NUMBER, 1);
                break;
            case R.id.chapter2:
                intent.putExtra(TOPIC_NUMBER, 2);
                break;
        }
        startActivity(intent);
    }

    ...

}