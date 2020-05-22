import java.util.Set;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.C3P0Registry;

// you probably want better Exception handling than this...
private DataSource findUniqueDataSource()
{
    Set set = C3P0Registry.getPooledDataSources();
    int sz = set.size();
    if ( sz == 1 ) // yay, just one DataSource
      return (DataSource) set.iterator().next();
    else 
      throw new RuntimeException("No unique c3p0 DataSource, found:" + sz);
}

// be sure you have configured a dataSourceName in your c3p0 or hibernate config
private DataSource findDataSourceByName( String dataSourceName )
{ return C3P0Registry.pooledDataSourceByName(dataSourceName); }