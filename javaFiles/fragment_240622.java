public synchronized DbHelper open() throws SQLException
{
    System.out.println ("running open");
    if(ourDatabase == null || !ourDatabase.isOpen());
    this.ourDatabase = getWritableDatabase();
    return this;
}