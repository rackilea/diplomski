private static final String CONNECTION_FACTORY_NAME ="connection factory name goes here";  

private static final String TOPIC_NAME = "Topic Name goes here";


private static final String SERVER_URL_PREFIX = "t3://";
private static final String SERVER_URL_SUFFIX = ".url.com:port";
private static final String USER = "";
private static final String PASSWORD = "";

private static final String LOCAL_DIRECTORY = "C:\\tmp\\poslog\\";


public static void main(String args[]) throws JMSException,
        NamingException, IOException, InterruptedException {

    System.out.println("start" + new Date());
    // INITIALIZE
    System.out.println("creating context for " + args[0]);
    Hashtable<String, String> properties = new Hashtable<String, String>();
    properties.put(Context.INITIAL_CONTEXT_FACTORY,
            "weblogic.jndi.WLInitialContextFactory");
    properties.put(Context.PROVIDER_URL, SERVER_URL_PREFIX + args[0] +      SERVER_URL_SUFFIX);
//properties.put(Context.SECURITY_PRINCIPAL, USER);
//properties.put(Context.SECURITY_CREDENTIALS, PASSWORD);
    InitialContext ctx = new InitialContext(properties);
    TopicConnectionFactory connectionFactory = (TopicConnectionFactory) ctx
            .lookup(CONNECTION_FACTORY_NAME);
    TopicConnection connection = connectionFactory.createTopicConnection();
    TopicSession session = connection.createTopicSession(false, 0);
    Topic topic = (Topic) ctx.lookup(TOPIC_NAME);
    TopicPublisher sender = session.createPublisher(topic);