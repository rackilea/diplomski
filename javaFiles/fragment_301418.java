class SuperClass {

    public void method() {
        System.out.println("SuperClass");
    }

}

class SubClass extends SuperClass {

    @Override
    public void method() {
        System.out.println("SubClass");
    }

    public SubClass() {
        method();
        this.method();
        super.method();
    }

}