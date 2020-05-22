import java.util.*; public class Details {
  public static void main(String args[]){
     ArrayList<String> arraylist = new ArrayList<String>();
     arraylist.add("AA");
     arraylist.add("ZZ");
     arraylist.add("CC");
     arraylist.add("FF");


     System.out.println("Before Sorting:");
     for(String str: arraylist){
          System.out.println(str);
      }

     /* Sorting in decreasing order*/
     Collections.sort(arraylist);
     Collections.reverse(arraylist);
     for(String str: arraylist){
          System.out.println(str);
      }

  }
}