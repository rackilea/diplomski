public someObject methodUnderTest() {
    SomeObject obj = getSomeObject();

    if(obj!=null){
      obj.someOtherMethod();
    }

    return someThing;
}

protected SomeObject getSomeObject() {
    return SomeAbstractClass.someMethod();
}