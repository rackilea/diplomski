public class YourClass extends Activity {

    private Button exampleButton;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        exampleButton = (Button)findViewById (R.id.myButton);

        exampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   
                Toast.makeText(YourClass.this, "I did something", Toast.LENGTH_SHORT).show();   
            }
        });
    }
}