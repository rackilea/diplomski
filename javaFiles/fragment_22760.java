import...
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView urlTextOut = (TextView) findViewById(R.id.result);
        new Thread() {

            final StringBuilder text = new StringBuilder();
            @Override
            public void run() {
                try
                {
                    String str;
                    URL url = new URL("My url");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    while ((str = in.readLine()) != null) {
                        text.append(str);
                    }
                    in.close();
                } catch (IOException ignored)
                {
                }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            urlTextOut.setText(text);
                        }
                    });

            }
        }.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}