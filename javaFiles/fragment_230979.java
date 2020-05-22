public class MainActivity extends AppCompatActivity {

EditText editText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    editText = (EditText) findViewById(R.id.editText);
    editText.addTextChangedListener(textWatcher);

}

TextWatcher textWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text=editText.getText().toString();
        String[] words=text.split("\\s+");
        if(words.length>1){
            editText.setError("Please donot enter more than a word!");
            editText.setText(words[0]);
        }
        else{
            Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(text);
            boolean b = m.find();

            if (b) {
                editText.setError("Please donot enter any special character!");
            }
        }
    }
}