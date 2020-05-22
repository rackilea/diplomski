public boolean Create(T user){
    QueryRunner run = new QueryRunner(dataSource);
try 
{
    run.update("INSERT INTO "+table+ getFields() +
            "VALUES " + getParameters(user)); 
}
catch (SQLException ex) 
{
    Log.logException(ex);
    return false;
}

    return true;
}

protected abstract String getFields(); 
protected abstract String getParameters(T user);