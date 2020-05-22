package recipeNo026;

public class PassArray {

  public static native void passDoubleArray(double[] array);
  static { System.loadLibrary("PassArray"); }

  public static void main(String[] args) throws Exception {
    for(int i=0; i<100; i++) {
      double[] doubleArray = new double[1_000_000_000];
      passDoubleArray(doubleArray);
      Thread.sleep(1000);
    }
  }
}