@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
classB {

    @Autowired
    private ClassC classC;

    classB(int a, SomeObjectA a) {
        //Logic with parameters
    }

    classB(int a, SomeObjectB b) {
        //Some logic
        classC.someMethod(b)
        //More logic
    }

    classB(int a, SomeObjectC c) {
        //Logic with parameters
    }
}

@Component
ClassA {
    @Autowired
    private ApplicationContext applicationContext;
    public void doSomething() {
        int a;
        SomeObjectB b;

        ClassB classB = null;
        classB = (ClassB) applicationContext.getBean("classB", a, ab);
    }

}