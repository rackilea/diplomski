// dbHandler class instance
dbHandler = new DBHandler(this);
try {

    dbHandler.createDataBase();
    contentLog.append("Database Created\n");

} catch (IOException ioe) {
    //throw new Error("Unable to create database");
}