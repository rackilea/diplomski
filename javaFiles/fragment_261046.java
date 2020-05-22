@Override
public void configure(Binder binder) {

    super.configure(binder);

    binder.install(new FactoryModuleBuilder().build(MyCustomClass.class));
}