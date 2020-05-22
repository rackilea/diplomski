public class SquareModule extends AbstractModule { // does not extend PrivateModule
  @Overide public void configure() {
    // this key is unique; each module needs its own!
    final Key<MyInterface> keyToExpose
        = Key.get(MyInterface.class, Names.named("square"));

    install(new PrivateModule() {
      @Override public void configure() {

        // Your private bindings go here, including the binding for MyInterface.
        // You can install other modules here as well!
        ...

        // expose the MyInterface binding with the unique key
        bind(keyToExpose).to(MyInterface.class);
        expose(keyToExpose);
      }
    });

    // add the exposed unique key to the multibinding
    Multibinder.newSetBinder(binder(), MyInterface.class).addBinding().to(keyToExpose);
  }
}