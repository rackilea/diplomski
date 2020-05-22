public class A {
  int temp, b;

  public void run() {
    double[] even = { 11.989898, 22.545454, 33.5454,
        44.444, 55.5647, 66.11111 }; // Dummy Values

    double[] odd = { 11.545454, 22.5454, 33.444,
        44.5647, 55.989898, 66.11111 }; // Dummy Values
    double[] out = new double[even.length
        + odd.length];

    int count = 0;
    for (int i = 0; i < out.length; i += 2) {
      out[i] = even[count];
      out[i + 1] = odd[count];
      count++;
    }

    for (int i = 0; i < out.length; i++) {
      System.out.print(out[i] + " ");
    }
  }

  public static void main(String[] args) {
    A obj = new A();
    obj.run();
  }
}