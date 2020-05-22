public class Segment implements Comparable<Object>{
     @Override
     public int compareTo(Object o) {
         if(o instanceof Segment)
         {
              return 0;
         }
         else if(o instanceof Point)
         {
             return 0;
         }

     }
}