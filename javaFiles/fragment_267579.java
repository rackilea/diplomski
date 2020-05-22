public class YourClass<T extends SomeSuperClass & Comparable<T>> {
     private int comp(T upper, T lower){
         return upper.compareTo(lower);
     }

     private int compare (T upper, T lower){
         return comp(upper, lower); 
     }
}