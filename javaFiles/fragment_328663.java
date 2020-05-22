@ConfigurationProperties
public class DataSourcesConfiguration {

    private Map<String, BasicDataSource> dataSources;

    public void setDataSources(Map<String, BasicDataSource> dataSources) {
        this.dataSources = dataSources;
    }

    Map<String, BasicDataSource > getDataSources() {
        return dataSources;
    }
}