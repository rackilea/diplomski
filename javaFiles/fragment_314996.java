public class AB<T extends A&B> implements A, B
{
    public final T v;

    @Override // A
    public int methodOfA(){ return v.methodOfA(); }