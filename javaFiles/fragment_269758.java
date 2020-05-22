public class DataSourceFactory {

@Resource(lookup = "jdbc/DFEP")
private javax.sql.DataSource datasource;

@Produces
@Named("queryDatasource")
public javax.sql.DataSource getDatasource() {
    return datasource;
}

}