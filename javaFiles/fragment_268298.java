TestAdapter mDbHelper = new TestAdapter(urContext);
mDbHelper.createDatabase();
mDbHelper.open();

Cursor testdata = mDbHelper.getTestData();

mDbHelper.close();