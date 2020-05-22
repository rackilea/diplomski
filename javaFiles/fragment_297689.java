public class AbstractDAO<T> {
private String table;
private String id_field;

public AbstractDAO(String table, String id_field){
this.table = table;
...
}

public T read(int id){
    try
{
    T user = run.query("SELECT * FROM "+ table + " WHERE "+id_field +" = ? ", id);
    return user;
}
catch (SQLException ex) 
{
    Log.logException(ex);
    return null;
}
}