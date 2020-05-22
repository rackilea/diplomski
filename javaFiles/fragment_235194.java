public class MainActivity extends AppCompatActivity {

    int i = 0;

    TextView wordTextView; // declare your textView here

    // no need to create array again in "getNextWord" method
    String[] array = {"Noun", "Adjective", "Proper Noun", "Name"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        // initialise text view here
        wordTextView = findViewById(R.id.wordTextView);
    }

    public void nextWord(View view) { //nextWord is the onclick of the button
        i = i++;
        getNextWord() // call this method here, without passing string
    }

    public void getNextWord() {
        // you need to check the value of "i", it should not be greater than "array" size.
        // you can simply do 
        // i = i% array.length
        // or you can check index with if-condition
        // otherwise you will get "ava.lang.ArrayIndexOutOfBoundsException" if i >= array.length
        wordTextView.setText(array[i]);    
    }
}