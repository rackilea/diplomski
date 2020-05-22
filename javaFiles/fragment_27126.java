@Configuration
@ConfigurationProperties(prefix="clamav")
public class ClamAvClient {

static final Logger logger = LoggerFactory.getLogger(ClamAvClient.class);


private String host;


private int port;


private int timeout;

//getters and setters

}