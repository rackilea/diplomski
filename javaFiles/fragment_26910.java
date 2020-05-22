@SuppressWarnings({"hiding", "unchecked"})
public class TestParamA<D,E,Z> extends TestParam<Z>
{
    public class Builder<T extends TestParamA<D,E,Z>, 
                         B extends TestParamA<D,E,Z>.Builder<? extends TestParamA<D,E,Z>, ? extends B, D, E>, 
                         D,E> 
                 extends TestParam<Z>.CommonBuilder<Builder<TestParamA<D,E,Z>,B, D,E>>
    {
        protected D d;
        protected E e;

        public Builder(String a, String b, String c)
        {
            super(a, b, c);
        }

        public B withD(D d)
        {
            this.d = d;
            return (B)this;
        }

        public B withE(E e)
        {
            this.e = e;
            return (B)this;
        }

        @Override
        public <T> T build()
        {
            TestParamA<D,E,Z> t = new TestParamA<>("TestParamA", a, b, c, z, d, e);
            return (T)t;
        }        
    }

    protected D d;
    protected E e;

    public TestParamA() {
        super();
    }

    protected TestParamA(String name, String a, String b, String c, Z z, D d, E e)
    {
        super(name, a, b, c, z);
        this.d = d;
        this.e = e;
    }

    public D getD()
    {
        return d;
    }

    public E getE()
    {
        return e;
    }

    @Override
    protected String getContent()
    {
        return ", D: " + d + ", E: " + e;
    }
}