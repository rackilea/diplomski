public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;
    Button mBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBackup = this.findViewById(R.id.backup);
        mBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDBHlpr.close();
                try {
                    backupDatabase();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ExternalStoragePermissions.verifyStoragePermissions(this);
        mDBHlpr = new DBHelper(this);
    }

    private void backupDatabase () throws IOException {
        FileInputStream fis = new FileInputStream (this.getDatabasePath("dados.db").getPath());
        String outFileName = Environment.getExternalStorageDirectory () + "/example/backup/" + String.valueOf(System.currentTimeMillis()) + "data.db";
        Log.d("OSFILEPATH",outFileName);
        File os = new File(outFileName);
        if (!os.getParentFile().exists()) {
            os.getParentFile().mkdirs();
        }
        OutputStream output = new FileOutputStream(os);
        byte [] buffer = new byte [1024];
        int length;
        while ((length = fis.read (buffer))> 0) {
            output.write (buffer, 0, length);
        }
        output.flush ();
        output.close ();
        fis.close ();
    }
}