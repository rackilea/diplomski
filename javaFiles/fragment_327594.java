@SpringBootApplication
public class So46453364Application implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(So46453364Application.class, args);
        Thread.sleep(10_000);
        ctx.close();
    }

    @Autowired
    private JmsTemplate template;

    @Override
    public void run(String... arg0) throws Exception {
        this.template.convertAndSend("foo", "foo", m -> {
            m.setStringProperty("foo", "bar");
            return m;
        });
        this.template.convertAndSend("foo", "foo", m -> {
            m.setStringProperty("foo", "baz");
            return m;
        });
    }

    @JmsListener(destination = "foo", selector = "foo = 'bar'")
    public void bar(Message in) {
        System.out.println("bar: " + in);
    }

    @JmsListener(destination = "foo", selector = "foo = 'baz'")
    public void baz(Message in) {
        System.out.println("baz: " + in);
    }

}