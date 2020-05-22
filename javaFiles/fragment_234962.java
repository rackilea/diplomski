@Component
public class A {
    private String value = "inside A";
    ...
}

@Component
public class B {
    private String b = "inside B";
    ...
}

@Configuration
@ComponentScan(basePackageClasses = A.class)
public class AppConfig {
    // No bean definitions here, but required for @ComponentScan
}