public class YourActivity extends Activity  implements OnClickListener {
     public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

   Button libButton =(Button) findViewById(R.id.button1);
    libButton.setOnClickListener(this);

    Button OtherButton =(Button) findViewById(R.id.button2);
    OtherButton.setOnClickListener(this);


   }

 @Override
  public void onClick(View v) {

    switch (v.getId()) {
    case R.id.button1: openResource();
                           break;
    case R.id.button2: //do something for second button...

     default : break;
         }