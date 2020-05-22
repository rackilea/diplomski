@SpringBootApplication
@EnableRetry
public class So51787951Application {

    public static void main(String[] args) {
        SpringApplication.run(So51787951Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(Foo foo) {
        return args -> {
            try {
                foo.foo("bar");
            }
            catch (Exception e) {

            }
        };
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

}