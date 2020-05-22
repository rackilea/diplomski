class SuperClass {

    public void method() {
        System.out.println("SuperClass");
    }

}

class SubClass extends SuperClass {

    public SubClass() {
        method();
        this.method();
        super.method();
    }

}