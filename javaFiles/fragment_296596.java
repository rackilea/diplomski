public class Demo{

    public static void main(String [] args) {
        String str = "54.45k";

        double num;

        try {
            num = Double.parseDouble(str);
            if((num == Math.floor(num)) && !Double.isInfinite(num)) {
                System.out.println("String is an Integer!");
            }else {
                System.out.println("String is a Double!");
            }
        } catch(Exception e) {
            System.out.println("String isn't an Integer or a Double!");
        }
    }
}