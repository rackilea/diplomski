// No @Component here
public class A {
    ...
}

// No @Component here
public class B {
    ...
}

@Configuration
// You probably don't need @ComponentScan anymore since
// no classes are annotated with @Component
@ComponentScan(basePackageClasses = A.class)
public class AppConfig {

    @Bean
    public A setBean() {
        A a = new A();
        a.setValue("inside A");
        return a;
    }

    @Bean
    public B setB() {
        B b = new B();
        b.setB("inside B");
        return b;
    }
}