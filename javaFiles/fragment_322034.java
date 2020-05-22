class Sample {
 int a;
 int b;

 Sample(int a, int b) {
    this.a = a;
    this.b = b;
 }

 public int sum() {
    return a + b;
 }
}

public class Testing {
 public static void main(String[] args) {
    Sample myTest = new Sample(1, 2);
    int sum = myTest.sum();
    System.out.println(sum);
 }
}