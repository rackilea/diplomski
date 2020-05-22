public class DoubleFormat {
    public static void main(String[] args) {
        float f =  0.41f;
        String s = Float.toString(f);

        System.out.println("0"+s); //Or
        System.out.printf("%05.2f\n", f);
    }
}