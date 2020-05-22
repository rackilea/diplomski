error: <T#1>f1() in Derived cannot override <T#2>f1() in Base
     <T> List<String> f1() {return null;}
                      ^
  return type List<String> is not compatible with List<? extends Number>
  where T#1,T#2 are type-variables:
    T#1 extends Object declared in method <T#1>f1()
    T#2 extends Object declared in method <T#2>f1()

error: <T#1>f3() in Derived cannot override <T#2>f3() in Base
     <T extends Number> List<String> f3() {return null; }
                                     ^
  return type List<String> is not compatible with List<T#1>
  where T#1,T#2 are type-variables:
    T#1 extends Number declared in method <T#1>f3()
    T#2 extends Number declared in method <T#2>f3()