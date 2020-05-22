public class YourApplication extends ResourceConfig {

    public YourApplication() {
        super();

        register(YourAuthenticationRequestFilter.class, Priorities.AUTHENTICATION);
        register(YourExceptionMapper.class);
        register(YourLoggingFilter.class);

        packages("...");
    }
}