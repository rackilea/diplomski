abstract class AbstractDao {
    public abstract String getID();
    public abstract void insert();
    public abstract void update();
    public abstract AbstractDao newInstance();
}
class SqlDao extends AbstractDao {
    public SqlDao() {}
    public String getID() {return "sql";}
    public void insert() {System.out.println("sql insert");}
    public void update() {System.out.println("sql update");}
    public AbstractDao newInstance() { return new SqlDao();}
}