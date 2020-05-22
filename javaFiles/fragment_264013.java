@SpringBootApplication
@ImportResource("context.xml")
public class So31923175Application {

    public static void main(String[] args) {
        SpringApplication.run(So31923175Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(Foo app) {
        return args -> {
            try {
                app.retry("foo");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    @Component
    public static class Foo {

        @Retryable
        public void retry(String param) {
            System.out.println(param);
            throw new RuntimeException("test retry");
        }

    }

}