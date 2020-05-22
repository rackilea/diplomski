import java.sql.*;

public class TestArr implements SQLData
 {
  private String sql_type;

  public String attrOne;
  public int    attrTwo;

  public TestArr() 
  { 
  }
  public TestArr (String sql_type, String attrOne, int attrTwo)
  {
    this.sql_type = sql_type;
    this.attrOne = attrOne;
    this.attrTwo = attrTwo;
   }

  // define a get method to return the SQL type of the object
  public String getSQLTypeName() throws SQLException
  { 
    return sql_type; 
  } 

  // define the required readSQL() method 
  public void readSQL(SQLInput stream, String typeName)
    throws SQLException
  {
    sql_type = typeName;

    attrOne = stream.readString();
    attrTwo = stream.readInt();
  }  
  // define the required writeSQL() method 
  public void writeSQL(SQLOutput stream)
    throws SQLException
  { 
    stream.writeString(attrOne);
    stream.writeInt(attrTwo);
  }
}