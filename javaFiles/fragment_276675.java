public static class A {
    public void test() throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + "-" + field.get(this).toString());
        }
    }
}

public static class B extends A {
    private String foo = "bar";
    public B() throws Exception {
        super();
        test();
    }
}

public static void main(String[] args) throws Exception {
    new B();
}