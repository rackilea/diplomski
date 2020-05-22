public boolean isRowExist(/*YOUR_INPUTS*/){
    try {
        db = mDBHelper.getReadableDatabase();
        String selectQuery =  YOUR_SEARCH_QUERY_STATMENT
         //You should use YOUR_INPUTS to create a selectQuery that can select the row/rows for you

        Cursor c = db.rawQuery(selectQuery, null);
        if(c.getCount()>=1){
            c.close();
            return true;
        }
        c.close();
        return false;
    } catch (Exception e) {
        return false;
    }
}