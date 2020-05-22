// bind shared singletons here
Injector parent = Guice.createInjector(new MySharedSingletonsModule());
// create new injectors that share singletons
Injector i1 = parent.createChildInjector(new MyModule1(), new MyModule2());
Injector i2 = parent.createChildInjector(new MyModule3(), new MyModule4());
// now injectors i1 and i2 share all the bindings of parent