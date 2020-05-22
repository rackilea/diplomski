@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static final Logger appLogger = LoggerFactory.getLogger(Application.class);

    // for JAR deploy:
    public static void main(String[] args) {
        SpringApplicationBuilder builder = configureSpringBuilder(new SpringApplicationBuilder());
        builder.application().run(args);
        appLogger.info("--Application Started--");
    }

    // for WAR deploy:
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(configureSpringBuilder(builder));
    }

    // Common:
    private static SpringApplicationBuilder configureSpringBuilder(SpringApplicationBuilder builder) {
        System.out.println("INIT");
        appLogger.info("Initializing");

        builder.application().addListeners(new InitializationLogger());
        builder.application().setSources(new HashSet<>(Collections.singletonList(Application.class)));

        return builder;
    }
}