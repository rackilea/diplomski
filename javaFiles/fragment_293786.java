@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan("com.sring.crud.*")
@EntityScan("com.sring.crud.model")
@EnableAutoConfiguration
public static void main(String[] args) {
    SpringApplication.run(SpringCrudApplication.class, args);
}