@Autowired
ApplicationContext applicationContext;

public void runCustomService(String serviceClassName){        
    BaseService baseService = applicationContext.getBean(serviceClassName);
    baseService.run();
}