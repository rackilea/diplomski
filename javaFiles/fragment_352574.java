public abstract class Model {
    public abstract String getTableName();

    public void loadModel ( String id ) {
        System.out.println ( "Tablename is: " + getTableName() );
    }
}

public class User extends Model {
    private String tablename = "users";

    public String getTableName()
    {
       return tablename;
    }

    @Override
    public void loadModel ( String id ) {
        super.loadModel(id);
    }
}