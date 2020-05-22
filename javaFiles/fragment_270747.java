public class A extends Activity {

 static A INSTANCE;
 String data="A"; 

 @Override
  public void onCreate(Bundle savedInstanceState) {

    INSTANCE=this; 
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
   }

 public static A getActivityInstance()
   {
     return INSTANCE;
   }

 public String getData()
   {
     return this.data;
   }
}