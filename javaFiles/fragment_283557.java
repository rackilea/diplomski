@Configuration
public class AppConfig {
    @Bean(name = "myInflux")
    public InfluxDb influxClient{
        return InfluxDBFactory.connect(databaseURL, userName, password);
    }
}