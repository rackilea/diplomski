@Bean
@Qualifier("myCustomizedDataSource")
public DataSource resourceAwareMyDataSource() {

    ResourceAwareMyDataSource dataSource = new ResourceAwareMyDataSource ();
    Map<Object, Object> targetDataSourcesMap = new HashedMap();
    targetDataSourcesMap.put("Primary", getPrimaryDataSource());
    targetDataSourcesMap.put("Secondary", getSecondaryDataSource());
    dataSource.setTargetDataSources(targetDataSourcesMap);
    return dataSource;
}