public class MyArray {
    int[] col1;
    double[] col2;

    public MyArray(int size) {
        col1 = new int[size];
        col2 = new double[size];
    }
    // ... add get/set methods as needed, e.g.

    public void setCol1(int pos, int value) {
        col1[pos] = value;
    }

    public void setCol2(int pos, double value) {
        col2[pos] = value;
    }
}