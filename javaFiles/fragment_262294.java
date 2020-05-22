public void initAdapter(Context ctx, ListView myListView) {
    String strquery = "SELECT unique_column_name AS _id,column1,column2,column3,column4 FROM MY_TABLE";
    cur = db.rawQuery(strquery,null);

    if (cur != null && cur.getCount() > 0) {
        String[] fromColumns = { "column1", "column2", "column3", "column4" };
        int[] toViews = { R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4 };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ctx, 
                R.layout.query_cell, cur, fromColumns, toViews, 0);
        myListView.setAdapter(adapter);
    }
}