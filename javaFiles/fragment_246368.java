class newClass extends outer.inner {

    private outer o;

    public newClass(outer outerInstance) {
        outerInstance.super();
        this.o = outerInstance;
    }

    void innerMethod() {
        o.outerMethod();
    }
}