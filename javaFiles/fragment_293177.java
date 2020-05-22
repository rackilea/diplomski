public boolean resultSetsEqual2 (ResultSet source, ResultSet target) throws SQLException{
    while(source.next())
    {
        target.next();
        ResultSetMetaData metadata = source.getMetaData();
        int count = metadata.getColumnCount();
        for (int i =1; i<=count; i++)
        {
             if(!source.getObject(i).equals(target.getObject(i))) //added !
             {
                  return false;
             }
        }
    }
    return true;
}