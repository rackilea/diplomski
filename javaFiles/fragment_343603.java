public class Dad1 extends AppCompatActivity {

private Handler handler;

private Runnable myRunnable;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initRunnable();
    handler.postDelayed(myRunnable,3000);
}

private void initRunnable() {
    myRunnable = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(getApplicationContext(), Dad2.class);
            startActivity(i);
            finish();
        }
    };
}

@Override
public void onBackPressed() {
    super.onBackPressed();
    if(handler!=null){
        handler.removeCallbacks(myRunnable);
    }
}