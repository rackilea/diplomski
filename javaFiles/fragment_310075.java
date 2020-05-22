public class MainActivity extends Activity {

//private Bitmap open, close;
private LinearLayout myL;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myL = (LinearLayout) findViewById(R.id.LinearLayout2);

    // myL=(LinearLayout) findViewById(R.id.LinearLayout2);

    //close = BitmapFactory.decodeResource(getResources(), R.drawable.kapa);
    //open = BitmapFactory.decodeResource(getResources(), R.drawable.ac);

}

@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();

    Runnable runnable = new Runnable() {
          @Override
          public void run() {

              while(true) {
              try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }

              MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myL.setBackgroundResource(R.drawable.kapa);

                }
            });
              try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }

              MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myL.setBackgroundResource(R.drawable.ac);

                    }
                });
            }
          }
        };
        new Thread(runnable).start();
}

}