@Component
public class WebFlowUtil {

    @Autowired
    private ApplicationContext applicationContext;

    public Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}