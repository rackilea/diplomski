@Bean
@Conditional(MyClass1Condition.class)
public class MyClass1 implements MyInterface {}

@Bean
@Conditional(MyClass2Condition.class)
public class MyClass2 implements MyInterface {}