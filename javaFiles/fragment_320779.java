@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private final StartupHandler startupHandler = new StartupHandler();

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        startupHandler.handle(servletContext);
        super.onStartup(servletContext);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder in) {
        startupHandler.addInitializersToApplication(in);
        return in.sources(Application.class);
    }