@SpringBootApplication
public class So49368515Application {

    public static void main(String[] args) {
        SpringApplication.run(So49368515Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template, Foo foo) {
        return args -> template.convertAndSend(foo.getDestination(), "test");
    }

    @JmsListener(destination = "#{@foo.destination}")
    public void listen(Message in) {
        System.out.println(in);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    public class Foo {

        public String getDestination() {
            return "foo";
        }
    }

}