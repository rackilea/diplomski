public class CacheManager {
    private static final Logger LOG = LoggerFactory.getLogger(CacheManager.class);

    private final AtomicInteger counter = new AtomicInteger();

    public void updateConfigurations() throws InterruptedException {
        LOG.info("update configurations");
        if (counter.getAndIncrement() == 0) {
            Thread.sleep(5000);
        }
        LOG.info("end update configurations");
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }
}