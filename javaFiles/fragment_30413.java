Database db = null;    
if (environment is android){
    db = new AndroidSQLiteDatabaseImpl();
} else {
    db = new MyBlackberrySQLiteImpl();
}