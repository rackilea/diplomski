public class secondActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent();
    i.putExtra("key", readDataFile());
    setResult(RESULT_OK, i);
    finish();
    }

    public String readDataFile() {
        String strData = null;
        InputStream is = null;
        try {
            is = getResources().openRawResource(R.raw.data_text);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            strData = br.readLine();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strData;
    }
}