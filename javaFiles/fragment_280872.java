@SpringBootApplication
public class Application extends SpringBootServletInitializer {

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
}//this was the one we were missing

public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
}

}