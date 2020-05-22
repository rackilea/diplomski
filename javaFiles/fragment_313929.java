/* package & imports.. */

public class MainActivity extends AppCompatActivity {

    private EditText textBox;
    private int z, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = findViewById(R.id.editText);
        setActual();
    }

    private void setActual() {
        Random random = new Random();
        int x = random.nextInt(10) + 1; //you get a random number between 0 and 9 then add 1 to get 1 - 10, no need to use array.. 
        int y = random.nextInt(10) + 1;
        z = x * y;
        String hintStr = x + " * " + y;
        ((TextView) findViewById(R.id.hintTextView)).setText(hintStr);
    }

    public void onCheck(View view) {

        this.answer = Integer.parseInt(textBox.getText().toString());
        String res = "Incorrect";
        if (answer == z) {
            res = "Correct";
            Log.d("TAG", "Correct."); // right answer

            setActual(); // let's regenerate values 

        } else {
            Log.d("TAG", "Incorrect."); // wrong answer
        }
        ((TextView) findViewById(R.id.result_text_view)).setText(res);
    }
}