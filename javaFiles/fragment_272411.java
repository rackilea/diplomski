public class B extends A{
      public B(double[] b){
           int[] arr = new int[1];
           arr[0] = b.length;
           super(arr);  // broken, super must be first.
      }
}