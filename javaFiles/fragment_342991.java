@Configuration
@ComponentScan(basePackages = {"spring.cli.config"})
public class Main {
    public static void main(String... args) throws Exception {
        ConfigurableApplicationContext spring = new SpringApplicationBuilder(Main.class)
                .web(NONE)
                .profiles("default")
                .run(args);

        TemplateEngine engine = (TemplateEngine) spring.getBean("engine");
        Context context = new Context();
        System.out.println(engine.process("template", context));
    }
}