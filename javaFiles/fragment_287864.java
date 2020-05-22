public class open extends Activity {
  private Activity  mActivity;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.open);
    android.app.ActionBar bar = getActionBar();
    bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A6250F")));
    mActivity = this;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
      public void run() {
        Intent i = new Intent(mActiviy, MainActivity.class);
        startActivity(i);
      }
    }
    handler.postDelayed(r, 2000);
  }
}