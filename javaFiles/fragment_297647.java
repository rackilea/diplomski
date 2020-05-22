/* Head ends here */
 import java.util.*;
 public class Solution {

      static void insertionSort(int[] ar,int n) {

          int key=ar[n-1];
          int temp;
          int inserted=0;
          for(int i=ar.length-2;i>-1;i--){
              temp=ar[i];
              if(temp>key)
              {
                  ar[i+1]=temp;
                  printArray(ar);
              }
              else {
                  ar[i+1]=key;
                  inserted=1;
                  break;

              }

          }

          if(inserted==0){
          ar[0]=key;
          }

          printArray(ar);
   }   

   /* Tail starts here */

  static void printArray(int[] ar) {
     for(int n: ar){
        System.out.print(n+" ");
     }
       System.out.println("");
  }

  public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] ar = new int[n];
       for(int i=0;i<n;i++){
          ar[i]=in.nextInt(); 
       }
       insertionSort(ar,n);
   }    
 }