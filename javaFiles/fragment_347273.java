@SpringBootApplication
public class So56226984Application {

    public static void main(String[] args) {
        SpringApplication.run(So56226984Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template, JmsListenerEndpointRegistry registry,
            ConfigurableApplicationContext context) {

        return args -> {
            Scanner scanner = new Scanner(System.in);
            String queue = scanner.nextLine();
            Properties props = new Properties();
            context.getEnvironment().getPropertySources().addLast(new PropertiesPropertySource("queues", props));
            while (!"quit".equals(queue)) {
                System.out.println("Adding " + queue);
                props.put("queue.name", queue);
                context.getBean("listener", Listener.class);
                template.convertAndSend(queue, "qux sent to " +  queue);
                System.out.println("There are now " + registry.getListenerContainers().size() + " containers");
                queue = scanner.nextLine();
            }
            scanner.close();
        };
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Listener listener() {
        return new Listener();
    }

    public static class Listener {

        @JmsListener(destination = "${queue.name}")
        public void listen(String in) {
            System.out.println(in);
        }

    }
}