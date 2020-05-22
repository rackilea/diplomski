@Configuration
public class TaskConf {

    @Autowired
    private FirstTaskService firstTaskService;

    @Autowired
    private SecondTaskService secondTaskService;

    @Bean
    public TaskScheduler<FirstTaskService> firstTaskServiceTaskScheduler(){
        TaskScheduler<FirstTaskService> t =  new TaskScheduler<>();
        t.setTaskService(firstTaskService);
        return t;
    }

    @Bean
    public TaskScheduler<SecondTaskService> secondTaskServiceTaskScheduler(){
        TaskScheduler<SecondTaskService> t =  new TaskScheduler<>();
        t.setTaskService(secondTaskService);
        return t;
    }

}