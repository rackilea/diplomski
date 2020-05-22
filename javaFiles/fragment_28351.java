public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    Button button;
    LinearLayout mainLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout=(LinearLayout)findViewById(R.id.myLayout);
        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                mainLayout.setBackgroundResource(R.drawable.yellowgradient);
            }
        });

        mHandler = new Handler();
        mRunnable = new Runnable(){
        @Override
        public void run() {
             i++;
             if(i==1){
             mainLayout.setBackgroundResource(R.drawable.image_one);
              }else if(i==2){
             mainLayout.setBackgroundResource(R.drawable.image_two);
              }else if(i==3){
             mainLayout.setBackgroundResource(R.drawable.image_three);
               i ==0;
              }

             mHandler.postDelayed(mRunnable , 10000);
            }
         }; 
        mHandler .post(mRunnable);
    }
}