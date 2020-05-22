@RequestMapping("/path")
public String handlerMethod() {
    PrototypeBean instance = factory.getObject();
    instance.someMethod();
    return "view";
}