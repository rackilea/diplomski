public class BubbleSort{

   public static void main(String[] args) {

      int a[] = {13, 33, 1, 32, 8, 10, 11, 6};
      bubbleSort(a);

   }

   public static void bubbleSort(int[] a) {
      int temp = 0;
      int n = a.length;

      for (int i = 0; i < n; i++) {
         for (int j = 1; j < (n - i); j++) {
            if (a[j - 1] > a[j]) {
               //swap elements  
               temp = a[j - 1];
               a[j - 1] = a[j];
               a[j] = temp;
            }

         }

      }
      // print array after sorting. 
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + " ");
      }
   }

}