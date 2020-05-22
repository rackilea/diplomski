public class MyComparator implements Comparator<Dog>{ 

     public int compare(Dog s1, Dog s2) { 
          return s1.getName().compareTo(s2.getName()); 
     } 
 }