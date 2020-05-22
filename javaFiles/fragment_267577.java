public class YourClass<T> {
     private int comp(Comparable<T> upper, Comparable<T> lower){
         return upper.compareTo((T) lower);
     }

     private int compare (Comparable<T> upper, Comparable<T> lower){
         return comp(upper, lower); 
     }
}