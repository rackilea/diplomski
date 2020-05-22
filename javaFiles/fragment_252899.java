public class Main {

    public static void main(String[]args) {

        try {
            double number = Double.parseDouble("138fj*28+/dg");
            System.out.println(true);
            // number
        }catch (NumberFormatException ex) {
            System.out.println(false);
            // not
        }

    }
}