@Autowired 
private ApplicationContext applicationContext;

public void createUser(Class<?> beanClass) {
    ILogic logic = applicationContext.getBean(beanClass);
    logic.saveUser();
}