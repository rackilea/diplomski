//final here disallows to subclass "Sample". This assures that there exists NO subclass that invokes bar().
public final class Sample {


    public void foo() {

        //on same instance
        this.bar();

        //on another instance, but just same class (or subclass of Sample, but not possible because class is final)
        Sample b = new Sample();
        b.bar();
    }

    /*final here prevents that METHOD is overwritten. But class can be overwritten.
     * subclasses are also allowed to invoke bar().
     */
    protected final void bar() {
        //do something here
    }
}