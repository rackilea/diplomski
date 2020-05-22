class Tuple<T1, T2>
{
    private T1 a;
    private T2 b;

    public Tuple1(T1 a, T2 b)
    {
        this.a = a;
        this.b = b;
    }

    public T1 getA() { return a; }

    public T2 getB() { return b; }

    @Override
    public String toString()
    {
        return "[" + a.toString() + ", " + b.toString() + "]";
    }
}

class Tuple2<T1, T2, T3> 
{
    private Tuple1<T1, T2> tuple;
    private T3 c;

    public Tuple2(T1 a, T2 b, T3 c)
    {
        this.tuple = new Tuple1<T1, T2>(a, b);
        this.c = c;
    }

    public T1 getA() { return tuple.getA(); }

    public T2 getB() { return tuple.getB(); }

    public T3 getC() { return c; }

    @Override
    public String toString()
    {
        return "[" + getA().toString() + ", " + getB().toString() + ", " + c.toString() + "]";
    }
}

class Tuple3<T1, T2, T3, T4> 
{
    private Tuple2<T1, T2, T3> tuple;
    private T4 d;

    public Tuple3(T1 a, T2 b, T3 c, T4 d)
    {
        this.tuple = new Tuple2<T1, T2, T3>(a, b, c);
        this.d = d;
    }

    public T1 getA() { return tuple.getA(); }

    public T2 getB() { return tuple.getB(); }

    public T3 getC() { return tuple.getC(); }

    public T4 getD() { return d; }

    @Override
    public String toString()
    {
        return "[" + getA().toString() + ", " + getB().toString() + ", " + getC().toString() + ", " + d.toString() + "]";
    }
}