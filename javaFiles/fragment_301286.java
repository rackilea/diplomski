@RunWith(SpringRunner.class)
public class BeanRemovalTest implements ApplicationContextAware {
    @Autowired
    private Bean1 bean1;

    @Autowired
    private Bean2 bean2;

    private ApplicationContext applicationContext;

    @Test
    public void test1() throws Exception {
        System.out.println("test1():");
        System.out.println("  bean1=" + bean1);
        System.out.println("  bean2.bean1=" + bean2.bean1);

        resetBean("bean1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("test2():");
        System.out.println("  bean1=" + bean1);
        System.out.println("  bean2.bean1=" + bean2.bean1);
    }

    private void resetBean(String beanName) {
        GenericApplicationContext genericApplicationContext = (GenericApplicationContext) applicationContext;
        BeanDefinition bd = genericApplicationContext
                .getBeanDefinition(beanName);
        genericApplicationContext.removeBeanDefinition("bean1");
        genericApplicationContext.registerBeanDefinition("bean1", bd);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
}