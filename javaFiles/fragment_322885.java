public class Test
{
    interface K<T> { }

    static class A<T>
    {
        class B implements K<T> { }

        public K<T> getK() { return new B(); }
    }

    A<String> a = new A<String>();
    A<String>.B b = (A<String>.B) a.getK();
}