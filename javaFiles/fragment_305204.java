@Configuration
@EnableScheduling
@ComponentScan("PACKAGES WITH SCHEDULED ANNOTATIONS")
public class ConfigScheduler implements SchedulingConfigurer {
    ...    
    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {

       ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
       scheduler.setPoolSize( threadpoolsize );
       scheduler.setThreadGroupName( threadgroupname );
       scheduler.setThreadNamePrefix( threadPrefix );
       scheduler.setAwaitTerminationSeconds( timeout );    
       return scheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {      
        TaskScheduler scheduler = this.taskScheduler();
        registrar.setTaskScheduler( scheduler );
    }
    ...
}