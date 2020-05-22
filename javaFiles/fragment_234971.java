@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer {
public static void main(String[] args) {
    new SpeedRestApplication()
        .configure(new SpringApplicationBuilder(SpeedRestApplication.class).environment(new MyEnvironment()))//Replace default StandardEnvironment
        .run(args);
   }
}