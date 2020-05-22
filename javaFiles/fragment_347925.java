public interface I {
    public void foo();
}

public class C implements I {
    public void foo(){ ... }
}

...
Classloader l1 = ...
I c1 = (I) l1.loadClass("some.pkg.C").newInstance();
c1.foo();

Classloader l2 = ...
I c2 = (I) l2.loadClass("some.pkg.C").newInstance();
c2.foo();