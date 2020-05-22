for(int i = 0; i<myIndexList.size(); i++)
{
    String[] s = null;
    Log.e("", "current pos "+i);
    Cursor mCur2 = mDb.sGetMySectionListData(myIndexList.get(i));
    if(mCur2.getCount()>0)
        {
            s = new String[mCur2.getCount()];
            mCur2.moveToFirst();
            do
                {
                    s[mCur2.getPosition()] = mCur2.getString(mCur2.getColumnIndex("section_data")));
                }
            while(mCur2.moveToNext());
        }
    mCur2.close();
    mGenerateString(s, i, myIndexList.size());
}