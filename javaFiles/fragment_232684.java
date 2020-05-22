public abstract class AbstractModel {

  public static ResultSet getAllFromTable(String tableName) {

    Statement stmt = Database.get().conn.createStatement();

    String query = "SELECT * FROM `" + tableName + "`";

    return stmt.executeQuery(query);
  }

}

public class Api extends AbstractModel {

  protected static final String TABLE_NAME = "apis";

  public static ResultSet getAll() {
    return getAllFromTable(TABLE_NAME);
  }

}