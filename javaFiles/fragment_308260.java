class Super{
    void superMethod(){}
}
class Sub extends Super{
    void subMethod(){}
}
class Sub2 extends Super{
    void subMethod2(){}
}

static <T extends Super> void processSuper(T input){
    // this is safe and compiles
    input.superMethod();

    // this doesn't compile
    input.subMethod();

    // nor this
    input.subMethod2();
}