import groovy.sql.Sql

public class ProductInfo {

  ReadProperty prop

  def sql
  public ProductInfo() {
    prop=ReadProperty.getInstance("db")
    sql = Sql.newInstance( "jdbc:oracle:thin:@"+prop.getProperty("hostname")+":"+prop.getProperty("port")+":"+prop.getProperty("service"), "asimonc", "asimon","oracle.jdbc.OracleDriver")
  }

  public List executeSelection(String query) {
    List result = []
    sql.eachRow(query) { 
      result << [ it.id, it.name, it.description, it.active, it.release_date ]
    }
    result
  }

  public void executeInsert( GString query ) {
    sql.execute( query )
  }

  public void executeUpdation( GString query ) {
    sql.executeUpdate( query )
  }

  public int executeSelectMax( String query ) {
    sql.firstRow(query)?.max ?: 0
  }
}