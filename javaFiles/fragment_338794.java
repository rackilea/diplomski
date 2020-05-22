public class Join extends Activity {

     EditText id;
     EditText password ;
     EditText name ;
     EditText phone ;
     Button join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        id = (EditText)findViewById(R.id.id);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        phone =(EditText)findViewById(R.id.phone);
        join = (Button)findViewById(R.id.join);
    }