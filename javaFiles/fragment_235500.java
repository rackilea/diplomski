@Override
public void onStart() {
    super.onStart();
    myDbHelper dbHelper = myDbHelper.getInstance(getActivity());
    dbHelper.logMode(dbHelper.getWritableDatabase(),"FRGONSTRT1",myDbHelper.DATABASE_NAME,getActivity());
    dbHelper.addUser("Fred","fred@fredmail.com","password");
    Cursor csr = dbHelper.getReadableDatabase().query(myDbHelper.TBL_USER,null,null,null,null,null,null);
    DatabaseUtils.dumpCursor(csr);
    csr.close();
}