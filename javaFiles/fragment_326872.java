interface I<T> {}
interface A<T> extends I<A<A<T>>>{}
abstract class X {
    abstract <T> T foo(T x, T y);

    void bar(A<Integer> x, A<String> y){
        foo(x, y);
    }
}