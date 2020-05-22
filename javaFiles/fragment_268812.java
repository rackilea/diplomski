public class abc extends Activity{
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        tv1=(TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();
        String pass= intent.getExtras().getString("key");
        if(pass!= null){
        tv1.setText(pass);
                }

}