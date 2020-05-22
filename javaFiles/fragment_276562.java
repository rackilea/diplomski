error: no suitable method found for of(Averager::new,Averager::accept,Averager::combine)
                      Collector.of(Averager::new, Averager::accept, Averager::combine))));
method Collector.<T#1,R#1>of(Supplier<R#1>,BiConsumer<R#1,T#1>,BinaryOperator<R#1>,Characteristics...) is not applicable
  (cannot infer type-variable(s) T#1,R#1
    (argument mismatch; bad return type in method reference
      void cannot be converted to R#1))
method Collector.<T#2,A,R#2>of(Supplier<A>,BiConsumer<A,T#2>,BinaryOperator<A>,Function<A,R#2>,Characteristics...) is not applicable
  (cannot infer type-variable(s) T#2,A,R#2
    (argument mismatch; bad return type in method reference
      void cannot be converted to A))
where T#1,R#1,T#2,A,R#2 are type-variables:
T#1 extends Object declared in method <T#1,R#1>of(Supplier<R#1>,BiConsumer<R#1,T#1>,BinaryOperator<R#1>,Characteristics...)
R#1 extends Object declared in method <T#1,R#1>of(Supplier<R#1>,BiConsumer<R#1,T#1>,BinaryOperator<R#1>,Characteristics...)
T#2 extends Object declared in method <T#2,A,R#2>of(Supplier<A>,BiConsumer<A,T#2>,BinaryOperator<A>,Function<A,R#2>,Characteristics...)
A extends Object declared in method <T#2,A,R#2>of(Supplier<A>,BiConsumer<A,T#2>,BinaryOperator<A>,Function<A,R#2>,Characteristics...)
R#2 extends Object declared in method <T#2,A,R#2>of(Supplier<A>,BiConsumer<A,T#2>,BinaryOperator<A>,Function<A,R#2>,Characteristics...)