public static void main(String[] args) 
{
  int[] array = {3, 6, 9, 12, 15, 19, 21, -1, -45, 0};
  int target = 2; 
  if(linearSearch(array,target)) {
      System.out.print("found");
  }
}