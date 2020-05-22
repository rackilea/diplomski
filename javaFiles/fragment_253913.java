@Configuration
@Component
public class MyServerContext {

    @Autowired
    private UserData userData; // autowire the result of userData() bean method

    @Bean
    public UserData userData() {
        UserData userData = new AWSUserDataFetcher(urlUtil()).fetchUserData();
        return userData;
    }   

    @PostConstruct
    public void setupKeyTrustStores() {
        // Setup TrustStore & KeyStore
        System.setProperty(SYS_TRUST_STORE, userData.get(TRUST_STORE_PATH));
        System.setProperty(SYS_TRUST_STORE_PASSWORD, userData.get(TRUST_STORE_PASSWORD));
        System.setProperty(SYS_KEY_STORE, userData.get(KEY_STORE_PATH));
        System.setProperty(SYS_KEY_STORE_PASSWORD, userData.get(KEY_STORE_PASSWORD));

        // Prevents handshake alert: unrecognized_name
        System.setProperty(ENABLE_SNI_EXTENSION, "false");
    }

    ...

}