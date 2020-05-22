public class LogbackLog implements Log {

    public void log(String message) {
        // call logback logger from here
    }
}

Log logger = new LogbackLog();

RestAdapter restAdapter = new RestAdapter.Builder()
            .setLog(logger)
            .setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(APP_URL)
            .setRequestInterceptor(new AuthRequestInterceptor())
            .setErrorHandler(new RetrofitErrorHandler()).build();