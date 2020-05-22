public void actualizatrat(Context context){
    dbHelper(context);
    db4oHelper.deleteAll();
    (...)
}

private Db4oHelper dbHelper(Context context) {
    if (db4oHelper == null) {
        db4oHelper = new Db4oHelper(context);
        db4oHelper.db();
    }
    return db4oHelper;
}