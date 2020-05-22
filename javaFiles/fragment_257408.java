class Bean {
    private String foo;
    private int bar;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }
}

class Beanuser {
    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setFoo("foo");
        bean.setBar(807);

        System.out.println("bean foo: " + bean.getFoo());
        System.out.println("bean bar: " + bean.getBar());
    }
}