public class LoggingInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //suppose you use default logback (ch.qos.logback.classic.LoggerContext)
        LoggerContext c = (LoggerContext) LoggerFactory.getILoggerFactory();
        c.getLogger("ru.varren").setLevel(Level.DEBUG);
        c.getLogger("org.springframework.web").setLevel(Level.ERROR);
        c.getLogger("org.springframework.security").setLevel(Level.ERROR);
        c.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG); 
    }
}