public class HeapSort extends Sort{ 
   public int sort(int arr[]) { 
      for (int i = 1; i < arr.length; i++) { // add to heap 
         int p = i;
         // int pp = p /2 ;  <======= Problem!
         int pp = (p-1) / 2; 
         while (p > 0 && arr[pp] < arr[p]) { 
            swap(arr, p, pp); p = pp; 
            //  pp = p / 2; // <=====Problem!
            pp = (p-1) /2;

}