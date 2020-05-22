public class MainActivity extends AppCompatActivity {

    EditText cnic1;
    EditText fcnic1;
    EditText bill1;
    ImageButton verify1;


    boolean isUserFound;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        cnic1 = (EditText) findViewById(R.id.cnic);
        fcnic1 = (EditText) findViewById(R.id.fcnic);
        bill1 = (EditText) findViewById(R.id.bill);
        verify1 = (ImageButton) findViewById(R.id.verify);



        db = new Database(this);


        //you forget onclick method
        verify1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                verification();
            }
        });

    }


    //Function for verification button
    public void verification()
    {
        if (cnic1.getText().toString().isEmpty() || fcnic1.getText().toString().isEmpty() || bill1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            isUserFound = db.getUserDetails(cnic1.getText().toString(),fcnic1.getText().toString(),bill1.getText().toString());
            if(isUserFound)
            {
                    Intent z = new Intent(MainActivity.this,hhActivity.class);
                    startActivity(z);
                }
                else
                {
                    Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
        }
    }
}