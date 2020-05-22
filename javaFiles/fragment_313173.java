public class SpringBean  {

@Autowired
private  ApplicationContext applicationContext;

private static SpringBean bean = new SpringBean();

public static SpringBean getInstance() {
    return bean;
}


public ApplicationContext getApplicationContext() {
    return applicationContext;
}

public Object getBean(String beanName) {
    if (applicationContext == null) {
        throw new IllegalStateException("No context  initialised.");
    }
    return applicationContext.getBean(beanName);
} 

}