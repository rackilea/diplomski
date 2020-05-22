@InjectLogger Logger log;

CtorInjectedStuff stuff;

@Inject Foo(CtorInjectedStuff stuff){
    this.stuff = stuff;
    log.info("created"); // null as fields are not yet injected
}     

@Inject public void postConstruct(){
    log.info("post construct"); // works
}