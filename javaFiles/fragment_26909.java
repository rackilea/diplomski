public abstract class TestParam<Z>
{
    public abstract class CommonBuilder<T extends CommonBuilder<T>>
    {
        protected final String a;
        protected final String b;
        protected final String c;
        protected Z z = null;

        public CommonBuilder(String a, String b, String c) 
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @SuppressWarnings("unchecked")
        public T withOptionalZ(Z z)
        {
            this.z = z;
            return (T)this;
        }

        @SuppressWarnings("hiding")
        public abstract <T> T build();
    }

    protected String name;
    protected String a;
    protected String b;
    protected String c;
    protected Z z = null;

    protected TestParam() {

    }

    protected TestParam(String name, String a, String b, String c)
    {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    protected TestParam(String name, String a, String b, String c, Z z)
    {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = z;
    }

    public String getA() 
    {
        return a;
    }

    public String getB()
    {
        return b;
    }

    public String getC()
    {
        return c;
    }

    protected abstract String getContent();

    @Override
    public String toString()
    {
        return name+"[A: " + a + ", B: " + b + ", C: " + c + (z != null ? ", Z: " + z.toString() : "") + getContent() +"]";
    }
}