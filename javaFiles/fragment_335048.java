public class Ooops<P, O> implements Comparable<Ooops<P, O>> {

    // your code

    @Override
    public int compareTo(Ooops<P, O> other) {
       return other.val - this.val;
    }

}