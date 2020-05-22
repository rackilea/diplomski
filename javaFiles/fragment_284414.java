@Override
 protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.row_item);
Button bDR = (Button) findViewById(R.id.bDR);
bDR.setOnClickListener(new OnClickListener(){

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new 
         AlertDialog.Builder(DeleteRenameList.this).create();
        builder.setCancelable(true);
        builder.setMessage("Would you like to delete or rename the list?");
        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setNeutralButton("Rename", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });

    AlertDialog.show();

    }

    });