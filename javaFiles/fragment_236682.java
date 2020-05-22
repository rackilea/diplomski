public class Read_from_db extends AsyncTask <String, Long, Void> {
    private final ProgressDialog dialog = new ProgressDialog(Read.this);
    private Activity callingActivity;
    public Read_from_db(Activity activity) {
        callingActivity = activity;
    }


    // can use UI thread here
    protected void onPreExecute() {
    this.dialog.setMessage("Wait\nSome SLOW job is being done...");
    this.dialog.show();
    }
    @Override
    protected Void doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        try {
            //txtMsg.append("\n");
            // obtain a list of from DB
                String TABLE_NAME = "classicpoems__poet_header";
                String COLUMN_ID = "_id";
             //   String _ID = "_id";
                String COLUMN_NAME = "poet_name";
                String COLUMN_CENTURY = "century_start";
                String [] columns ={COLUMN_ID,COLUMN_NAME,COLUMN_CENTURY};

            Cursor c = db.query(TABLE_NAME,columns,null, null, null, null, COLUMN_ID);
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(Read.this, R.layout.list_item, c, 
                       new String[] {COLUMN_ID,COLUMN_NAME,COLUMN_CENTURY}, new int[] {R.id.list_item_text_id,R.id.list_item_text_main,R.id.list_item_text_sub}, 0);

            ListView list = (ListView) findViewById(R.id.list_poet_name);
            list.setAdapter(adapter);

            } catch (Exception e) {
                Toast.makeText(callingActivity, e.getMessage(), 1).show();
                Log.i(TAG,  e.getMessage());
            }
        db.close();
        return null;
    }
    // can use UI thread here
    protected void onPostExecute(final Void unused) {
    if (this.dialog.isShowing()) {
    this.dialog.dismiss();
    }
    // cleaning-up, all done
    this.dialog.setMessage("Done");

    }
}