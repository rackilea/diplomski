@Bean
@Profile("!dev")
public class MyClass1 implements MyInterface {}

@Bean
@Profile("dev")
public class MyClass2 implements MyInterface {}