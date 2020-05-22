private void populateListViewFromDB() {

    Cursor cursor = myDb.getAllRows();

    startManagingCursor(cursor);

    String[] fromFieldNames = new String[]
            {GPSDatabase.COLUMN_LAT}; //I'm using only one column for tesing
    int[] toViewIDs = new int[]
            {R.id.latTextView};

    SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(
            this,                       
            R.layout.item_layout,       
            cursor,                     
            fromFieldNames,             
            toViewIDs                   
            );


    ListView myList = (ListView) findViewById(R.id.list);
    myList.setAdapter(myCursorAdapter);
}