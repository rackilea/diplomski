public class MainActivity extends AppCompatActivity {

    static final String DB1NAME = "db1", DB2NAME = "db2", DB3NAME = "db3";
    DatabaseHlpr mDB1Hlpr, mDB2Hlpr, mDB3Hlpr;
    File db1File, db2File,db3File;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB1Hlpr = new DatabaseHlpr(this,DB1NAME,0);
        mDB2Hlpr = new DatabaseHlpr(this,DB2NAME,0);
        mDB3Hlpr = new DatabaseHlpr(this,DB3NAME,1);
        mDB1Hlpr.close();
        mDB2Hlpr.close();
        mDB3Hlpr.close();
        db1File = new File(this.getDatabasePath(DB1NAME).getPath());
        db2File = new File(this.getDatabasePath(DB2NAME).getPath());
        db3File = new File(this.getDatabasePath(DB3NAME).getPath());
        String result = " the same ";
        if (!CompareDBSchemas.areDBSchemasEqual(db1File,db2File,false)) {
            result = " NOT the same ";
        }
        Log.d("RESULTINFO",
                "Database Schemas are " + result +
                        " for " +
                        "\n\t" +db1File.getPath() +
                        "\n and \n\t" + db2File.getPath()
        );

        result = " the same ";
        if (!CompareDBSchemas.areDBSchemasEqual(db1File,db3File)) {
            result = " NOT the same ";
        }

        Log.d("RESULTINFO",
                "Database Schemas are " + result +
                        " for " +
                        "\n\t" +db1File.getPath() +
                        "\n and \n\t" + db3File.getPath()
        );
    }
}