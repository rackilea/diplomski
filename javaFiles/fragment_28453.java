@Configuration
public class DataAccessConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource =  mock(Datasource.class);
        return dataSource;
    }

    @Bean
    public Map<String,String> someMap() {
        Map<String, String> map = new HashMap<>();
        map.put("someDao.sql", "somevalue");
        return map;
    }

}