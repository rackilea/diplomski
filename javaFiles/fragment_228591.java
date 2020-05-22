public class Main {
    double[] arr = new double[10];

    static void modifyArray(double[] modArr) {
        modArr[0] = 3;
    }

    public static void main(String...args) {
        Main inst = new Main();
        modifyArray(inst.arr);
    }
}