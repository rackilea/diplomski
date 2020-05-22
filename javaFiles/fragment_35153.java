public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the database (only if it doesn't exists)
        // does so by copying from the assets
        if (CopyDBFromAssets.createDataBase(this,IntDataBaseHelper.DB_NAME)) {
            IntDataBaseHelper myhelper = new IntDataBaseHelper(this);

            // Get the data from the database
            ArrayList<String> jobs = myhelper.getJobList();
            for (String s: jobs) {
                Log.d("TESTDB","Found Job " + s);
            }
        } else {
            throw new RuntimeException("No Usable Database exists or was copied from the assets.");
        }
    }
}