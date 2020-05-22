public class Varb{
    public static void main(String[] args) {

        double[] array = new double[10];
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Enter" + " " + array.length + " numbers");
        for (int c = 0; c < array.length; c++) {
            array[c] = input.nextDouble();
        }
        min(array);
    }

    private static double min(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}