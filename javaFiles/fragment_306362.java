public class Main extends Activity implements OnClickListener {

   private int no1=0;
   private int no2=0;
   private int op=0;
   private int flag=0;
   private EditText display1;

   public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main);


     display1=(EditText) findViewById(R.id.display);    


     Button one= (Button) findViewById(R.id.one);  
     one.setOnClickListener(this);
   }


    public void onClick(View v) {

      if(v.getId()==R.id.one)
      {
        switch(flag)
        {
        case 1:no1*=10+1;display1.setText(no1);
        case 2:no2*=10+1;display1.setText(no2);
        }


   }
}