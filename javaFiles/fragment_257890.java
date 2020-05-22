public static class TesteP {

    private String a;
    private String b;
    private String c;


    public String getA() {
        return this.a;
    }


    public void setA(String a) {
        this.a = a;
    }


    public String getB() {
        return this.b;
    }


    public void setB(String b) {
        this.b = b;
    }


    public String getC() {
        return this.c;
    }


    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this.getClass()).add("a", this.a).add("b", this.b).toString();
    }

}

 public static class RestP {

    private String a;

    public String getA() {
        return this.a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return this.a;
    }
}

public static void main(String[] args)
        throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    TesteP p = new TesteP();
    p.setA("AAAA");
    p.setB("BBB");
    TesteP pp = new TesteP();
    RestP p2 = new RestP();
    p2.setA("aaaa");
    PropertyUtils.copyProperties(p,p2);

}