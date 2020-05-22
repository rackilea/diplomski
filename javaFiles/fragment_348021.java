Create or Replace Java Source Named "Hello" As

import java.sql.*;
import java.io.*;

public class Hello implements SQLData {
  private int helloId;
  public String World() { return "Hello World!"; }
  String sql_type;

  public String getSQLTypeName() throws SQLException {
    return sql_type;
  }

  public void readSQL(SQLInput stream, String typeName) throws SQLException {
    sql_type = typeName;
    helloId = stream.readInt();
  }

  public void writeSQL(SQLOutput stream) throws SQLException {
    stream.writeInt(helloId);
  }
}