public class HelloGridView extends Activity {
private GridView gridview;
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    gridview = (GridView) findViewById(R.id.gridview);
    gridview.setAdapter(new ImageAdapter(this));
    ((ImageAdapter) gridview.getAdapter()).initializemThumbIds();

    gridview.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            showDialog(0);
        }
    });
}

protected Dialog onCreateDialog(int id) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   gridview.setAdapter(new ImageAdapter(this));  // gridview cannot be resolved
                   dialog.cancel();
               }
           })
           .setNegativeButton("No", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   HelloGridView.this.finish();
               }
           });
    AlertDialog diag = builder.create();
    return diag;
}
}