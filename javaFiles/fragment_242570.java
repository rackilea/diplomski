@SpringBootApplication
public class SpringBootApp {

    public static void main(String... args) {
        new SpringApplicationBuilder(SpringBootApp.class)
            .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
                @Override
                public void initialize(GenericApplicationContext applicationContext) {
                    applicationContext.setAllowBeanDefinitionOverriding(false);
                }
            })
        .run(args);

    }
}