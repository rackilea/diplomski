public class FileAndDirectoryActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST = 1000;
    private ArrayList<String> mNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_and_directory);
        //Check if we have the permission to read storage
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //We dont have the permission, so request it.
            ActivityCompat.requestPermissions(thisActivity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST);
        }
        //We already have permission
        else{
            permissionExists();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PERMISSION_REQUEST){
            if(resultCode == RESULT_OK){
                permissionExists();
            }
            else{
                //handle error
            }
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void permissionExists(){
        File directory = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        File[] arrayFiles = directory.listFiles();
        for (File file : arrayFiles) {
            mNames.add(file.getName());
        }
        initRecyclerView();
    }
}