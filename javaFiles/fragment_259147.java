public class S1 {}

@Typed(S2.class)
public class S2 extends S1 {}

public class A {
    @Inject S1 service;
}

public class B {
    @Inject S2 service;
}