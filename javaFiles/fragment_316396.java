import java.util.*;
class Mclass {
    public static void main(String[] args) {
        char[] a= {'a','b','c','d','a','b','c'};
        int count = 0;
        Arrays.sort(a);  // sort the array
        for (int i=0; i<a.length; i++)
        {
          for(int j=i; j<a.length; j++)
          {
              if ( a[j] == a[i] ){
                  count += 1;
                  continue;
              }          
              i=j-1;
              break;
          }
          System.out.println(a[i]+":"+count);
          count = 0;
        }
    }
}