// 1) Convert array to String, for eg. [1,2,3,4] => "1234". 
// 2) Use Strings substring/lastIndexOf to find the correct index. 

private static int findSubarrayPosition(int[] array, int[] subarray) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < array.length; i++) {
          sb.append(array[i]);
      }
      String string = sb.toString();

      sb = new StringBuilder();
      for (int i = 0; i < subarray.length; i++) {
          sb.append(subarray[i]);
      }
      String subString = sb.toString();

      return string.lastIndexOf(subString);
}