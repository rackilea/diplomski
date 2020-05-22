public class welcome1 extends Activity {

@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
            .detectDiskReads().detectDiskWrites().detectNetwork()
            .penaltyLog().build());
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome1);

    final TextView welcome = (TextView) findViewById(R.id.textView7);
    final TextView person = (TextView) findViewById(R.id.textView9);
    final Intent v = getIntent();    final String abt = v.getStringExtra("frist_name");
    Runnable myRun=new Runnable() {
        @Override
        public void run() {
            for (int  s=0;s<2;s++){
                final int finalI =s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       if (finalI==0)
                       {
                           welcome.setText(welcome2);
                                person.setText(abt);
                       }
                        if (finalI==1)
                                welcome.setText(steps);
                    }
                });
                try {
                    wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String number = v.getStringExtra("mobile_number");
                        String pwd = v.getStringExtra("pass");

                        Intent d = new Intent(getBaseContext(),gps.class);
                        d.putExtra("mobile_number",number);
                        d.putExtra("pass", pwd);
                        startActivity(d);
                    }
                });
            }
        }
    };

    Thread T=new Thread(myRun);
    T.start();
}