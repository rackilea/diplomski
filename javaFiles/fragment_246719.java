//SubClass extends SuperClass
    protected void getSuperSuper((ITestContext context) {
        super.setUp(context);
    }

    //ChildClass extends SubClass
    protected void setUp(ITestContext context) {
        super.getSuperSuper(context);
        ...
    }