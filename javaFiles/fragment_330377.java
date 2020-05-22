class Outer<T>{
    private T t;
    class Inner{
        void method(T tt){//we can use same type T as used in outer class
            t = tt;
        }
    }
}