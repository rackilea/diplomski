public class FooSubscaleNormTable<E extends Enum<E>> implements NormTable<E> {
    public Integer percentileForRawScore(E e, int score) {
       if(e instanceof Subscale) {
           switch((Subscale) e) {
           case X:
           // do something
           break;
           }
       }
       // return 0; 
    }
}