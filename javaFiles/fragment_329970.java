@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan("com.buhryn.interviewer.models")
public class Application {

    public static void main(String[] args) {
        System.out.println("--------------------------- Start Application ---------------------------");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        if (emf.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return emf.unwrap(SessionFactory.class);
    }
}