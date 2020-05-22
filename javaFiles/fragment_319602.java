public class MainActivity extends AppCompatActivity {

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this);
        // Add a row for tesing
        database.insertData("A","B","C","D",
                "E","F","G","H","I",
                "J","K","L","M","N",
                "O","P","Q","R","S",
                "T","U","V","W","X",
                "Y","Z","AA","AB","AC",
                "AD","AE","AF"
        );
        // Get all the rows (1) and dump the resultant Cursor
        Cursor csr = database.getAllRowsFromCurrencyTable();
        DatabaseUtils.dumpCursor(csr);
        csr.close(); // Should always close a Cursor when done with it.

    }
}