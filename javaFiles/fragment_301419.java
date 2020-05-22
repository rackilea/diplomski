class SuperClass {

    protected String field = "SuperClass";

}

class SubClass extends SuperClass {

    public SubClass(String field) {
        System.out.println(field);
        System.out.println(this.field);
        System.out.println(super.field);
    }

}