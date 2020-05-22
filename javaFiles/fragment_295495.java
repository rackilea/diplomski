public  ArrayList<SalesItemInformationLV> retrieveAllForlist(Context c)
{
    ArrayList<SalesItemInformationLV> items = new ArrayList<SalesItemInformationLV>();

    Cursor myCursor;
    String mystring = "";

    MyDbAdapter db = new MyDbAdapter(c);
    db.open();
    //contactIdList.clear();
    //contactList.clear();
    myCursor = db.retrieveAllEntriesCursor();

    if (myCursor != null && myCursor.getCount() > 0)
    {
        myCursor.moveToFirst();
        do {
            items.add(new SalesItemInformationLV(myCursor.getString(db.COLUMN_NAME_ID), db.COLUMN_QTYSOLD_ID));
        } while (myCursor.moveToNext());
    }
    db.close();

    return items;
}