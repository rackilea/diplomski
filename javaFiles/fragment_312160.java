@Configuration
public class MyConfig {
    @Bean(name="executeTimeInterceptor")
    public ExecuteTimeInterceptor getExecuteTimeInterceptor() {
        return new com.mkyong.common.interceptor.ExecuteTimeInterceptor();
    }

    @Bean(name="maintenanceInterceptor")
    public MaintenanceInterceptor getMaintenanceInterceptor(@Value("${properties.maintenanceStartTime}") int maintenanceStartTime,
                                                            @Value("${properties.maintenanceEndTime}") int maintenanceEndTime,
                                                            @Value("${properties.maintenanceMapping}") String maintenanceMapping) {

        MaintenanceInterceptor myInt = new MaintenanceInterceptor();
        myInt.setMaintenanceStartTime(maintenanceStartTime);
        myInt.setmMaintenanceEndTime(maintenanceEndTime);
        myInt.setMaintenanceMapping(maintenanceMapping);
        return myInt;
    }
}