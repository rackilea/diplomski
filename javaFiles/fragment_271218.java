class C<T> {
     T id(T x) {...}
 }
 interface I<T> {
     T id(T x);
 }
 class D extends C<String> implements I<Integer> {
    public String  id(String x)  {...}
    public Integer id(Integer x) {...}
 }