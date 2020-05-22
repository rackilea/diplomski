@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringObjectPoolTest {
    public static void main(String[] args) throws Exception {
        context = new SpringApplicationBuilder(SpringObjectPoolTest.class) //
                .addCommandLineProperties(false) //
                .web(false) //
                .headless(false) //
                .registerShutdownHook(true) //
                .application() //
                .run();

        context.getBean(SpringObjectPoolTest.class).go();
    }

    private static ConfigurableApplicationContext context;

    @Resource(name = "pfb")
    private MyTask pooledTask;

    @Resource(name="pool")
    private CommonsPoolTargetSource targetSource;

    @Bean(name = "task")
    @Scope("prototype")
    public MyTask createNewTask() {
        return new MyTask();
    }

    @Bean(name = "pool")
    public CommonsPoolTargetSource setupObjectPool() {
        CommonsPoolTargetSource pc = new CommonsPoolTargetSource();
        pc.setMaxSize(25);
        pc.setTargetBeanName("task");

        return pc;
    }

    @Bean(name = "pfb")
    public ProxyFactoryBean createProxyFactoryBean() {
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setTargetSource(setupObjectPool());

        return pfb;
    }

    private void go() {
        try {
            pooledTask.speak();

            // getting another object from pool
            MyTask someOtherTask = (MyTask) targetSource.getTarget();

            // returning the object to the pool
        targetSource.releaseTarget(someOtherTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}