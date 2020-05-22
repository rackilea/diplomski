public void Update(String newName, String newFName,String id, String oldName, String oldFName){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(COL2,newName);
    cv.put(COL3,newFName);
    String whereClause = COL1 + "=? AND " + COL2 + "=? AND " + COL3 + "=?";
    String[] args = new String[]{id, oldName,oldFName};
    db.update(TABLE_NAME,cv,whereClause,args);
}