@Remote
public interface IService {

    void upload();

}

@Stateless
public class Service implements IService {

    @EJB
    private AsyncUploadStateSender uploadStateSender;

    @Override
    public void upload() {
        for (int i = 0; i <= 100; i += 10) {
            uploadStateSender.sendState(i);
            try {
                Thread.sleep(1000L);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


@Stateless
public class AsyncUploadStateSender {

    @Resource(lookup = "jms/myQueue")
    private Queue queue;

    @Inject
    private JMSContext jmsContext;

    @Asynchronous
    public void sendState(final int state) {
        final JMSProducer producer = jmsContext.createProducer();
        final TextMessage msg = jmsContext.createTextMessage("STATE CHANGED " + state + "%");
        producer.send(queue, msg);
    }
}

public class Client {

    public static void main(final String args[]) throws NamingException, InterruptedException, JMSException {

        final InitialContext ctx = ... // create the InitialContext;
        final IService service = (IService) ctx.lookup("<JNDI NAME OF IService>");
        final ConnectionFactory factory = (ConnectionFactory) ctx.lookup("jms/__defaultConnectionFactory");
        final Queue queue = (Queue) ctx.lookup("jms/myQueue");
        // set consumer
        final Connection connection = factory.createConnection();
        final MessageConsumer consumer = connection.createSession().createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(final Message msg) {
                try {
                    System.out.println(((TextMessage) msg).getText());
                } catch (final JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        connection.start();
        // start upload
        service.upload();
        Thread.sleep(1000L);
    }
}