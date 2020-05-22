class WrapperMethods extends HundredMethods {
    public void method1(double d) {
        int i = (assigned a value in "code" below)
        super.method1(i);
    }

    public void method1(int i) {
        // Make sure that any calls that happen to pass in an integer,
        // also go by your logic.
        this.method1((double)i);
    }
}