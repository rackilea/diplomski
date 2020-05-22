public class MainActivity extends AppCompatActivity {


Button button;
private EditText name;  
private EditText number;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //initialization of the EditText and the Button
     name = (EditText) findViewById(R.id.Name);
     number = (EditText) findViewById(R.id.Number);
     button = findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            Intent intent = new Intent(getApplicationContext(), DisplayMessage.class);

            String mName = name.getText().toString();
            String mNumber = number.getText().toString();
            //Checking if the Entries are empty
            if(mName!=null&&mNumber!=null) {
                intent.putExtra("Name", mName);
                intent.putExtra("Number", mNumber);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Text Entries Missing",Toast.LENGTH_SHORT).show();
            }
        }
    });