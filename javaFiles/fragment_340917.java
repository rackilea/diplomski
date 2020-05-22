public class MainActivity extends AppCompatActivity implements FirebaseResponseListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddNewWord = findViewById(R.id.button);
        btnAddNewWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nullPoint np = new nullPoint();
                np.listener = this; // Initialize the listener here
                np.takeCount();
            }
        });
    }

    public void setTextView(int count){
        TextView tv = findViewById(R.id.textView);
        tv.setText("count = " + count);
    }

    @Override
    void onFirebaseResponseReceived(int count) {
        setTextView(count);
    }
}