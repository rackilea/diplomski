@SpringBootApplication
public class So56226984Application {

    public static void main(String[] args) {
        SpringApplication.run(So56226984Application.class, args);
    }

    @JmsListener(destination = "${foo.bar}")
    public void listen(String in) {
        System.out.println(in);
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("baz", "qux");
    }

}