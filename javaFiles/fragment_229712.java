abstract class Seek<T> {
   abstract <S> Seek<S> seek(S o); // <- no more yellow squiggle
   abstract <T1,T2> void map(Func<T1,T2> call); // <- no more yellow squiggle
   interface Func<I,O> {
      public O call(I x);
   }
   public <X1,X2> void go(Func<X1,X2> c, X1 some) {
      seek(some).map(c); // <- no more yellow squiggle here on 'c'
   }
 }