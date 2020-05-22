public class MyClass {
  public static void main(String args[]) {
    System.out.println(sumGenerator(100, 10)); // 450
  }
  private static int sumGenerator(int termination, int increment) {
    int i = 0, sum = 0;
    for (i=0; i<termination; i += increment){
        sum += i;
    }
    return sum;
  }
}