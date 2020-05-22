public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create database helper object
        DatabaseHelper helper = new DatabaseHelper(this);
        helper.open();

        // insert url to database
        ContentValues values;

        values = new ContentValues();
        values.put("POS", "1");
        values.put("URL", "file:///android_asset/1.html");
        helper.insertURL(values);


        values = new ContentValues();
        values.put("POS", "2");
        values.put("URL", "file:///android_asset/2.html");
        helper.insertURL(values);

        values = new ContentValues();
        values.put("POS", "3");
        values.put("URL", "file:///android_asset/3.html");
        helper.insertURL(values);

        // so on

        // get url using position
        String pos = "1"; 
        Cursor c = helper.getURL(pos);
        c.moveToFirst();
        String url = c.getString(c.getColumnIndex("URL"));
        System.out.println("URL "+url);
        c.close();

        helper.close();
    }
}