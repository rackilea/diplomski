public class BMI {

        public static double CalWt(Scanner type) {
            System.out.println("Please enter your Weight in lbs: ");
            return type.nextDouble() * .45359;
        }

        public static double CalHt(Scanner type) {
            System.out.println("Please enter your Height in inches: ");
            return type.nextDouble()* .025;
        }

        public static double CalBMI() {
            Scanner type = new Scanner(System.in);
            return CalWt(type) / Math.pow(CalHt(type),2);
        }

        public static void main(String[] args) {
            System.out.println(CalBMI());
        }
    }