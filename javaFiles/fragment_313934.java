public static void main(String args[]) {
   int[] arr = {1,2,3};
   test(arr);
   System.out.println(arr[0]); // This would print 13 now.
}

public static void test(int[] arr) {
   arr[0] = 13;
}