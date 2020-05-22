@Configuration
 @EnableJms
 public class JmsConfiguration implements JmsListenerConfigurer {
    ...
    // register here your jms listners
    @Override
    public void configureJmsListeners{
    ...
    }
 }