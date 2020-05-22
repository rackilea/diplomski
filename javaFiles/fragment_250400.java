public abstract class MyClass {

    protected MyService myService;

    doSomething() {
        return myService.doSomething();
    }
}

class MyClassV1 extends MyClass {
    MyClassV1(MyService myService) {
        this.myService = myService;
    }
}

class MyClassV2 extends MyClass {
    MyClassV2(MyService myService) {
        this.myService = myService;
    }
}

@Bean
MyClassV1 myClassV1() {
    return new MyClassV1(myServiceV1());
}

@Bean
MyClassV1 myClassV2() {
    return new MyClassV2(myServiceV2());
}

@Bean
MyServiceV1 myServiceV1() {
    return new MyServiceV1();
}

@Bean
MyServiceV2 myServiceV2() {
    return new MyServiceV2();
}