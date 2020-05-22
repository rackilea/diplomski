public class MainActivity extends Activity {
TextView _tv,tv2;
Timer _t;
int _count=0;


/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    _tv = (TextView) findViewById( R.id.textView1 );
    _t = new Timer();
    _tv.setText(R.string.app_name);
    _t.scheduleAtFixedRate( new TimerTask() {
            @Override
            public void run() {
                _count++;

                runOnUiThread(new Runnable() //run on ui thread
                 {
                  public void run() 
                  { 

                      _tv.setText(""+_count);
                      if(_count==99)
                      {
                          _t.cancel();
                      }
                 }
                 });
            }
        }, 1000, 1000 ); //change this value of 1000 to whatever you need.


}
@Override
protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();

    _t.cancel();
}  
}