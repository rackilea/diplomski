Handler handler = new Handler();
 handler.postDelayed(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub

            Intent newActivity = new Intent(MyPage.this , MainActivity.class);
            startActivity(newActivity);
        }
    }, 3000);


public class MyPage extends Activity{

@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
 super.onCreate(savedInstanceState);
 setContentView(R.layout.splash);
 Handler handler = new Handler();
 handler.postDelayed(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub

            Intent newActivity = new Intent(MyPage.this , MainActivity.class);
            startActivity(newActivity);
        }
    }, 3000);

    }