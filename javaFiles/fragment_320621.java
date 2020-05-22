@Service
@Slf4j
public class SingletonBean implements InitializingBean {

    @Autowired
    private ApplicationContext context;

    public PrototypeBean getPrototypeBean() {
        return context.getBean(PrototypeBean.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (String name : context.getBeanDefinitionNames()) {
            Class<?> c = context.getBean(name).getClass();
            log.debug("===> Name: {}, Type = {}", name, c.getTypeName());
        }
    }

}