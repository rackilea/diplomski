class MyClass {

    protected String name;

    public MyClass(String fn) {
        name = fn;
    }

    public String getName() {
        return name;
    }
}

class YourClass extends MyClass {

    public YourClass(String fn) {
        super(fn);
    }
}