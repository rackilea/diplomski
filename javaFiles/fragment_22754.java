public class MainActivity extends AppCompatActivity implements View.OnClickListener {
int i;
Button btn;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = 0;
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        }

   @Override
    public void onClick(View v) {

        if (v == btn) {
          i++;
           if(i == 5)        //assuming you want click to be five times
            {  
                Toast.makeText(MainActivity.this,
                        "your Message", Toast.LENGTH_LONG)
                        .show();
            }  else{
                 int j =5-i;  
                 Toast.makeText(MainActivity.this,
                        "you are"+j+"steps away", Toast.LENGTH_LONG)
                        .show();
    }      
 }
}
}