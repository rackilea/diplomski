class A {
    @Inject A(MembersInjector<B> bInjector) {
        ...
        B b = constructor.newInstance();
        bInjector.injectMembers(b);
        b.doSomething();
    }
}