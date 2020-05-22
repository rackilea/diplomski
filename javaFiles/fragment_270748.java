public class B extends Activity {

 String data; 

 @Override
  public void onCreate(Bundle savedInstanceState) {
    data=A.getActivityInstance().getData();  
   }
}