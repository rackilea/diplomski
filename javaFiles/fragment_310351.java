public class Register extends AppCompatActivity {

    public EditText editname;
    public EditText editemail;
    public EditText editmobile;
    public EditText editpassword;
    public EditText editrepassword;

    String error_code="";
    boolean flagmob = false;
    boolean flagemail = false;
    boolean flagpass = false;
    private static final String REGISTER_URL = "http://127.0.0.1/class/register.php";
    String check="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        editname = (EditText)findViewById(R.id.name);
        editemail = (EditText)findViewById(R.id.email);
        editmobile = (EditText)findViewById(R.id.mobile);
        editpassword = (EditText)findViewById(R.id.password);
        editrepassword = (EditText)findViewById(R.id.repassword);
    }

    public void onregister(View view) {

        Validation validation = new Validation();
        String name = editname.getText().toString();
        String email = editemail.getText().toString();
        String mobile = editmobile.getText().toString();
        String password = editpassword.getText().toString();
        String retypePassword = editrepassword.getText().toString();

        String validatedMobile = validation.validateMobile(mobile);
        boolean validatedEmail = validation.isEmailValid(email);
        String validatedPassword = validation.validatePassword(password, retypePassword);
        //do stuff with validated data

    }
}