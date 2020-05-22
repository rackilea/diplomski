@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {


        ApplicationContext ctx = SpringApplication.run(SpringApplication.class, args);

        Pet dog = (Pet) ctx.getBean("fido");
        System.out.println(dog.getName());
    }
}


@Configuration
class AppConfig {

    @Bean
    public Pet fido() {
        Pet p = new Pet();
        p.setName("fido");
        return p;
    }
}


class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}