/**
 * Listener for application start
 */
@Bean
public StartEventListener startListener() {
    return new StartEventListener(Module.PARSING);
}