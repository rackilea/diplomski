public static class CollectionsSort {
         public static void main(String[] args) {
               LinkedList<Integer> originalList = new LinkedList<>();
               originalList.add(3);
               originalList.add(2);
               originalList.add(1);

               Integer[] arr = list.toArray(new Integer[list.size()]);
               int[] intArray = new int[arr.length];
               for (int i = 0; i < intArray.length; i++) {
                   intArray[i] = arr[i].intValue();
               }
               mergesort(intArray);
               for (int i = 0; i < arr.length; i++) {
                   arr[i] = new Integer(intArray[i]); 
               }
               LinkedList<Integer> newList = new LinkedList(Arrays.asList(arr));
               Iterator it = newList.iterator();
               while(it.hasNext()) {
                  System.out.print((int)(it.next()) + " ");
               }
         }

         public static int[] mergesort(int[] arr) {
               int low = 0;
               int high = arr.length-1;
               mergesort(arr, low, high);
               return arr;
         }

         public static void mergesort(int[] arr, int low, int high) {
               if (low == high) {
                   return;
               } else {
                   int middle = low + (high-low)/2;
                   mergesort(arr, low, middle);
                   mergesort(arr, middle+1, high);
                   merge(arr, low, middle, high);
               }
         }

         public static void merge(int[] arr, int low, int mid, int high) {
               int[] left = new int[mid-low+2];
               for (int i = low; i <= mid; i++) {
                   left[i-low] = arr[i];
               }
               left[mid-low+1] = Integer.MAX_VALUE;
               int[] right = new int[high-mid+1];
               for(int i = mid+1; i <= high; i++) {
                   right[i-mid-1] = arr[i];
               }
               right[high-mid] = Integer.MAX_VALUE;
               int i = 0, j = 0;
               for(int k = low; k <= high; k++) {
                   if(left[i] <= right[j]) {
                      arr[k] = left[i];
                      i++;
                   } else {
                      arr[k] = right[j];
                      j++;
                   }
               }
         }
     }