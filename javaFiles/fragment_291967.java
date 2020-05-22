class PojoBuilder {
    private String foo;
    private int bar;
    private String a, b;

    public PojoBuilder withFoo(String foo) {
        this.foo = foo;
        return this;
    }

    public PojoBuilder withBar(int bar) {
        this.bar = bar;
        return this;
    }

    public PojoBuilder withA(String a) {
        this.a = a;
        return this;
    }

    public PojoBuilder withB(String b) {
        this.b = b;
        return this;
    }

    public PojoA buildA() {
        PojoA a = new PojoA();
        buildCommon(Wrapper.proxy(a, Pojo.class));
        a.setA(this.a);
        return a;
    }

    public PojoB buildB() {
        PojoB b = new PojoB();
        buildCommon(Wrapper.proxy(b, Pojo.class));
        b.setB(this.b);
        return b;
    }

    private void buildCommon(Pojo common) {
        common.setFoo(foo);
        common.setBar(bar);
    }
}

// Common setters for all pojos
interface Pojo {
    void setFoo(String foo);
    void setBar(int bar);
}

// One of the pojos.
// Note that this doesn't actually implement Pojo
class PojoA {
    private String foo;
    private int bar;
    private String a;

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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}

class PojoB {
    private String foo;
    private int bar;
    private String b;

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

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}