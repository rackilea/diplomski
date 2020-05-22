@Component
@Profile("local")
public class LocalFoo implements Foo {

    @Override
    public void bar() { ... }
}

@Component
@Profile("prod")
public class ProdFoo implements Foo {

    @Override
    public void bar() { ... }
}