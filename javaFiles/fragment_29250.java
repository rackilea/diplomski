public class MyModule extends AbstractModule implements MethodInterceptor {

@Override
public Object invoke(MethodInvocation methodInvocation) throws Throwable {

    System.out.println("Intercepted@invoke!");

    return methodInvocation.proceed();
}

@Override
protected void configure() {
    bind(Integer.class).annotatedWith(Names.named("nonsense")).toInstance(29);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(Calibrated.class), this);
}

public static void main(String... args) {
    Dummy dummy = Guice.createInjector(new MyModule()).getInstance(Dummy.class);

    dummy.doSomething();

    System.out.println(dummy.getNonsense());
}
}