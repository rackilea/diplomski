@EnableAutoConfiguration
@Configuration
@ComponentScan("com.somePackage")
public class Main {
    ApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);

    SomeBean myBean = ctx.getBean(SomeBean.class);
    myBean.doSomething();//succeeds

    AnyOtherClass aoc = ctx.getBean(AnyOtherClass.class);

}