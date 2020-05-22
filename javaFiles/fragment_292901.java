public interface Equatable<T extends Equatable<T>>
{
    boolean equalTo (T other);
}
public MyClass implements Equatable<MyClass>
{
    String str;
    public boolean equalTo (MyClass other) 
    {
        return str.equals(other.str);
    }
}
public Another implements Equatable<MyClass>
{
    public boolean equalTo (MyClass other)
    {
        return true;
    }
}

....
MyClass a = ....;
Another b = ....;

if (b.equalTo(a))
    assertTrue (a.equalTo(b));
....