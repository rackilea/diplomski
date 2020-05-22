public abstract class Model {

    public Model() {}

    abstract String getTableName();
}

public class User extends Model() {
    public String getTableName(){
      return "users";
    }
}