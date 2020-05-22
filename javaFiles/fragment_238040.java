public class AndroidListFilesActivity extends ListActivity {

    File root;
    File pdf;

    private List<String> fileList = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath());
        // ListDir(root);

        pdf = new File(root, "PDF");
        ListDir(pdf);
    }

    void ListDir(File f) {
        File[] files = f.listFiles();
        fileList.clear();
        for (File file : files) {
            fileList.add(file.getPath());
        }

        ArrayAdapter<String> directoryList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fileList);

        setListAdapter(directoryList);

    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        //selection.setText(fileList.indexOf(simple_list_item_1));
        OpenPdf(fileList.get(position).toString());
    }

    public void OpenPdf(String path)
    {
          File file = new File(path);
          if (file.exists()) {
              Uri p = Uri.fromFile(file);
              Intent intent = new Intent(Intent.ACTION_VIEW);
              intent.setDataAndType(p, "application/pdf");
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

              try {
                  startActivity(intent);
              } 
              catch (ActivityNotFoundException e){
              }
          }
    }
}