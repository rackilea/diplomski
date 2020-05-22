mydb.cursor.close();
    Log.i("Success1", "Access Started");
    try {
        cursor = mydb.getAllRows(gamemanager.hometeam);
    }catch (Throwable ex) {
        Log.i("Error", "Maybe retrying i dont know");
    }
    Log.i("Success!4", "Cursor is Active!" );
    startManagingCursor(cursor);
    Log.i("Success!5", "Cursor is being managed");
    String[] fromfieldnames = new String[]{DatabaseHelper.COL_2, DatabaseHelper.COL_3,
            DatabaseHelper.COL_23, DatabaseHelper.COL_24};
    Log.i("Success6", "Stage1");
    int[] toviewids = new int[]{R.id.scorecplayer, R.id.scorecsur, R.id.scorecballs, R.id.scorecruns};
    Log.i("Success7", "Stage2");
    mycursoradaptor = new SimpleCursorAdapter(this, R.layout.scorecardbat,
            cursor, fromfieldnames, toviewids);
    Log.i("Success8", "Stage3");
    batting.setAdapter(mycursoradaptor);
    Log.i("Success9", "Stage4");