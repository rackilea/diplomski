public class MainActivity extends AppCompatActivity {

Button signIn, signUp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    signIn = (Button) findViewById(R.id.'idOfButtonFromXMLLayout');
    signUp = (Button) findViewById(R.id.'idOfButtonFromXMLLayout');

    //Looking at my XML code, the signIn id would be R.id.signInButton
}