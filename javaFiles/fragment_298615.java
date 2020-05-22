@Override
protected void onResume() {
    super.onResume();
    arrayListAndAdapter();

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();

        //Which columns I want to select
        String[] projection = {
                WineContract.WineEntry.COLUMN_ID,
                WineContract.WineEntry.COLUMN_WINE_NAME,
                WineContract.WineEntry.COLUMN_WINE_PRICE,
                WineContract.WineEntry.COLUMN_WINE_DESCRIPTION};

        Cursor cursor = db.query(WineContract.WineEntry.TABLE_NAME, projection,null,null,null,null,null);
        cursor.moveToPosition(position);
        Intent intentGoToDetails = new Intent(MainActivity.this,DetailsActivity.class);
        String name = cursor.getString(cursor.getColumnIndex(WineContract.WineEntry.COLUMN_WINE_NAME));
        String price = cursor.getString(cursor.getColumnIndex(WineContract.WineEntry.COLUMN_WINE_PRICE));
        String description = cursor.getString(cursor.getColumnIndex(WineContract.WineEntry.COLUMN_WINE_DESCRIPTION));
        intentGoToDetails.putExtra("NAME", name);
        intentGoToDetails.putExtra("PRICE", price);
        intentGoToDetails.putExtra("DESCRIPTION", description);
        startActivity(intentGoToDetails);

    }
});