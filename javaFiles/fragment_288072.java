import groovy.sql.Sql 

class DataSourceAccessingService {
  def datasource

  def runSomeQuery( String sql ) {
    def sql = new Sql( datasource )
    ...
  }
}