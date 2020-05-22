@SpringBootApplication
public class DemoApplication {

    public static class CustomGenerator extends AnnotationBeanNameGenerator {

        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            /**
              * access bean annotations or package ...
              */
            return super.generateBeanName(definition, registry);
        }
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoApplication.class)
                .beanNameGenerator(new CustomGenerator())
                .run(args);
    }
}