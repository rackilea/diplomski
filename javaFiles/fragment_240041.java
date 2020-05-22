//Class where you setup DropWizard
public class SomeApplication extends Application<SomeConfiguration> {

    @Override
    public void run(SomeConfiguration conf, Environment environment) throws Exception {

        //Remove all default ExceptionMappers
        ((DefaultServerFactory)conf.getServerFactory()).setRegisterDefaultExceptionMappers(false);

        //Register your custom ExceptionMapper for ConstraintViolationException
        environment.jersey().register(new CustomExceptionMapper());

        //Restore the default ExceptionsMappers that you just removed
        environment.jersey().register(new LoggingExceptionMapper<Throwable>() {});
        environment.jersey().register(new JsonProcessingExceptionMapper());
        environment.jersey().register(new EarlyEofExceptionMapper());
    }
}