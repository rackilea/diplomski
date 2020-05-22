@RunWith(SpringRunner.class)
@SpringBootTest(classes = { So53678801Application.class,
        So53678801ApplicationTests.TestConfig.class})
public class So53678801ApplicationTests {

    @ClassRule
    public static EmbeddedKafkaRule embededKafka = new EmbeddedKafkaRule(1, false, "so53678801");

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.kafka.bootstrap-servers",
                embededKafka.getEmbeddedKafka().getBrokersAsString());
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private ListenerWrapper wrapper;

    @Test
    public void test() throws Exception {
        this.template.send("so53678801", "{\"bar\":\"baz\"}");
        assertThat(this.wrapper.latch.await(10, TimeUnit.SECONDS)).isTrue();
        assertThat(this.wrapper.argsReceived[0]).isInstanceOf(Foo.class);
        assertThat(((Foo) this.wrapper.argsReceived[0]).getBar()).isEqualTo("baz");
        assertThat(this.wrapper.ackCalled).isTrue();
    }

    @Configuration
    public static class TestConfig {

        @Bean
        public static ListenerWrapper bpp() { // BPPs have to be static
            return new ListenerWrapper();
        }

    }

    public static class ListenerWrapper implements BeanPostProcessor, Ordered {

        private final CountDownLatch latch = new CountDownLatch(1);

        private Object[] argsReceived;

        private boolean ackCalled;

        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof Listener) {
                ProxyFactory pf = new ProxyFactory(bean);
                pf.setProxyTargetClass(true); // unless the listener is on an interface
                pf.addAdvice(interceptor());
                return pf.getProxy();
            }
            return bean;
        }

        private MethodInterceptor interceptor() {
            return invocation -> {
                if (invocation.getMethod().getName().equals("processIncomingMessage")) {
                    Object[] args = invocation.getArguments();
                    this.argsReceived = Arrays.copyOf(args, args.length);
                    Acknowledgment ack = (Acknowledgment) args[1];
                    args[1] = (Acknowledgment) () -> {
                        this.ackCalled = true;
                        ack.acknowledge();
                    };
                    try {
                        return invocation.proceed();
                    }
                    finally {
                        this.latch.countDown();
                    }
                }
                else {
                    return invocation.proceed();
                }
            };
        }

    }

}