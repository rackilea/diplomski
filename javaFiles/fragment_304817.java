public class PurgeQueuesBeforeSuite extends TestRunnerBeforeSuiteSupport {

@Autowired
@Qualifier("connectionFactory")
ConnectionFactory queueConnectionFactory;

@Override
public void beforeSuite(TestRunner runner) {
    runner.purgeQueues(action ->
    action.connectionFactory(queueConnectionFactory)
            .queue("QUEUE_NAME_1")
    .queue("QUEUE_NAME_2")
    .queue("QUEUE_NAME_3"));
  }
}