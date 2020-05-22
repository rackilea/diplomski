public class Mainactivity extends FragmentActivity{
    OnDataPass dataPasser;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //When you create your fragment, keep a reference of it in the dataPasser variable
        dataPasser = /* your storage fragment class or any other fragment that implements onDataPass*/
        ......
        receiver = new BroadcastReceiver() {
              @Override
               public void onReceive(Context context, Intent intent) {
                    String str = intent.getStringExtra("data");
                    dataPasser.onDataPass(str);
               }
        };
    }       


    public interface OnDataPass {
        public void onDataPass(String data);
    }
}