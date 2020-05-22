public static boolean linearSearch(int[] array, int target)
 {
   for (int i = 0; i < array.length; i++){ 
     if(array[i] == target){
        return true;
   }
   return false;  
 }
}