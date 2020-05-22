@Configuration
@EnableTwitter(appId="myAppId", appSecret="myAppSecret")
@EnableJdbcConnectionRepository
public class TwitterConfig {

    @Autowired
    private TwitterConnectInterceptor twitterConnectInterceptor;

    @Bean
    public UserIdSource userIdSource() {
        return new UserIdSource() {         
            @Override
            public String getUserId() {
                return "myTestingPurposesLogin";
            }
        };
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        CustomConnectController connectionController = new CustomConnectController(connectionFactoryLocator, connectionRepository);
        connectionController.addInterceptor(twitterConnectInterceptor);
            return connectionController;
    }

    @Bean
    public TextEncryptor textEncryptor() {
        return Encryptors.noOpText();
    }

}