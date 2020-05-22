@SpringBootApplication
public class SpringHibernateDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringHibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(CustomerDao dao) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Customer customer = new Customer();
                customer.setFistName("amar");
                customer.setLastName("dev");
                customer.setEmail("amar@gmail.com");
                dao.save(customer);
            }            
        };
    }
}