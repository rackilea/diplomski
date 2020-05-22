@ImportResource({"spring-quartz-context.xml"})
public class BeanConfig {
    //autowired from xml
    @Autowired JobDetailFactoryBean jobDetailFactory;
    @Autowired CronTriggerFactoryBean cronTriggerFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(LocalContainerEntityManagerFactoryBean entityManagerFactory) {

        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setApplicationContextSchedulerContextKey("applicationContext");

        bean.setSchedulerName("MyScheduler");

        //used for the wiring
        Map<String, Object> schedulerContextAsMap = new HashMap<String, Object>();
        schedulerContextAsMap.put("noaJobDAO", noaJobDAO());
        schedulerContextAsMap.put("noaJobInstancesDAO", noaJobInstancesDAO());
        schedulerContextAsMap.put("esbClient", this.esbClient());
        bean.setSchedulerContextAsMap(schedulerContextAsMap);

        bean.setQuartzProperties(quartzProperties());

        return bean;
    }

    @Bean
    public Properties quartzProperties() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
        Properties properties = null;
        try {
            propertiesFactoryBean.afterPropertiesSet();
            properties = propertiesFactoryBean.getObject();

        } catch (IOException e) {
            log.warn("Cannot load quartz.properties.");
        }

        return properties;
    }

    // other beans (as included in the question)
}