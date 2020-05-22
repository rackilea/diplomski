public class MainActivity extends Activity implements OnClickListener {
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button wifiBtn = (Button) findViewById(R.id.wifi_on);
    wifiBtn.setOnClickListener(this);  // your onClick below will be called then you will still have to check the id of the Button
    // multiple buttons can set the same listener and use a switch like above

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

@Override
public void onClick(View v) {
    // TODO Auto-generated method stub

}