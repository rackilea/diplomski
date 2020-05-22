public class MyPair<T extends Comparable<T>, O extends Comparable<O>> extends Pair<T, O> implements Comparable<MyPair<T, O>> {
    @Override
    public int compareTo(MyPair<T, O> other) {
           //Now the compiler knows that T and O types are Comparable (that 
           //is they implement the Comparable interface) and 
           //this means their compareTo() can be used

           return this.getFirst().compareTo(other.getFirst()); 
    }
}