public class PurgeQueuesBeforeSuite extends TestRunnerBeforeSuiteSupport {

    @Autowired
    @Qualifier("connectionFactory")
    ConnectionFactory queueConnectionFactory;

    @Value("${my.out.queue.name}")
    private String myOutQueueName;

    @Override
    public void beforeSuite(TestRunner runner) {
        runner.purgeQueues(action ->
        action.connectionFactory(queueConnectionFactory)
                .queue(myOutQueueName));
    }
}