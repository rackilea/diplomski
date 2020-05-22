class SuperClass {

    protected String field = "SuperClass";

}

class SubClass extends SuperClass {

    private String field = "SubClass";

    public SubClass(String field) {
        System.out.println(field);
        System.out.println(this.field);
        System.out.println(super.field);
    }

}