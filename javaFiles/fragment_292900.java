public interface Equatable<T> {
    boolean equal (T a, T b);
}
public class MyClass
{
    String str;

    public static class MyClassEquatable implements Equatable<MyClass> 
    { 
         public boolean equal (MyClass a, MyClass b) { 
             return a.str.equals(b.str);
         } 
    }
}
...
public <T> methodThatNeedsToEquateThings (T a, T b, Equatable<T> eq)
{
    if (eq.equal (a, b)) { System.out.println ("they're equal!"); }
}