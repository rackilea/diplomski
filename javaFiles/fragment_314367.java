public class BookTag implements Comparable<BookTag> {

     //compares this tag with another: 0 indicates equality, 1 means this is  
     //bigger, -1 means the other is bigger
     public int compareTo(BookTag other) { 

          int c = this.left.compareTo(other.left); //string implements this
          if(c != 0) { 
                return -c; //if the other's left is "smaller", this object is "bigger"
          }

          c = this.mid - other.mid;
          if(c != 0) { 
                return -c; //if the other's mid is "smaller", this object is "bigger"
          }

           c = this.right.compareTo(other.right);
           if(c != 0) { 
                return c; //if the other's right is "bigger", this object is "bigger"
          }

          return 0; //if we get here, then all values are equal, and so are the objects
     }   
}