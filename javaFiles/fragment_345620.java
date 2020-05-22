public class Main {

    public static void main(String[] args) {
        System.out.println(isNumber(20, 21));
    }

    public static double isNumber (double n1, double n2){
        double calc = n1++ / n2;
        System.out.println(n1); // Prints 21
        return calc;
    }
}