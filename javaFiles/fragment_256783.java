public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new DatabaseHelper(this);
        loadExternalData();
    }


    private void loadExternalData() {

        InputStream importdata;
        BufferedReader br;
        String line;
        String[] splitdata;
        int linecount = 0;

        final String tag = "loadExternalData";
        try {
            importdata = this.getAssets().open("Book1.csv");
        } catch (IOException e) {
            Log.d(tag,"Error opening asset file");
            return;
        }
        br = new BufferedReader(new InputStreamReader(importdata));
        try {
            while ( (line = br.readLine()) != null) {
                // Skip column headings
                if (linecount++ > 0) {
                     splitdata = line.split(",");
                     dbh.insertRow(
                             splitdata[0],
                             new Integer(splitdata[1]),
                             splitdata[2],
                             splitdata[3]
                     );
                }
            }
        } catch (IOException e) {
            Log.d(tag,"IO Error reading data at line " + (linecount + 1));
            e.printStackTrace();
        }
    }
}