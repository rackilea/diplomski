try {
    Cursor cursor = mDb.query(....);
    if( cursor.moveToFirst() ) {
        .....
    }
} catch ( Exception e ) {
    e.printStackTrace();
}