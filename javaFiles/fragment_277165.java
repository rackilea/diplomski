public class Album implements Comparable<Album> {
   ...
   public int compareTo(Album other) {
     int cmp = title.compareTo(other.title);
     if (cmp == 0) {
       cmp = singer.compareTo(other.singer);
     } 
     return cmp;
   }
}