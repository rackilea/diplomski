@SpringBootApplication
@Log
public class NatiaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        startH2Server();
        SpringApplication.run(NatiaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        startH2Server();
        return application.sources(NatiaApplication.class);
    }

    private static void startH2Server() {
        try {
            Server h2Server = Server.createTcpServer().start();
            if (h2Server.isRunning(true)) {
                log.info("H2 server was started and is running.");
            } else {
                throw new RuntimeException("Could not start H2 server.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: ", e);
        }
    }
}