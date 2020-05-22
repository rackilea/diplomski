// scan classpath for all registered 
// implementations of Module interface
ServiceLoader<Module> loader = ServiceLoader.load(Module.class);
for (Module module : loader) {
    module.doSomething();
}