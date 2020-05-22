interface YourInterface {
    ...
}

class A implements YourInterface {
    ...
}

class B implements YourInterface {
    ...
}

class YourModule extends AbstractModule {
    @Override protected void configure() {
        Multibinder.newSetBinder(YourInterface.class).addBinding().to(A.class):
        Multibinder.newSetBinder(YourInterface.class).addBinding().to(B.class):
    }
}