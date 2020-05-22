@Component 
public class MyAuthenticationEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationEventListener.class);

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        logger.info("User logged in: " + authenticationSuccessEvent.getAuthentication().getName());
    }

}