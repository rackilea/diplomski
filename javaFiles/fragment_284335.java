TextView tvnum =null;
Button btnMin=null;
@Override
protected void onCreate(Bundle savedInstanceState) //TODO solve runtime problem(E/AndroidRuntime: FATAL EXCEPTION: main)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
 tvnum = (TextView) findViewById(R.id.TV_num);//creating object of TextView
int id = 100;//id is first number of tv num
btnMin = (Button) findViewById(R.id.btnMIN);
}