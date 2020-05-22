public class SimpleConvertor {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        double length = 0.39370;

        System.out.println("Welcome to simple convertor.");

        boolean cont = true;
        while (cont) {
            System.out.println("Pick an option and its corresponding letter to select.");
            System.out.println("Farenheight to Celsius: f");
            System.out.println("Celsius to Farenheight: c");
            System.out.println("Inches to Centimeters: i");
            System.out.println("Centimeters to Inches: ce");
            System.out.println("");
            System.out.println("Make your choice: ");
            String choice = input.nextLine();

            if ( choice.equals("f") ) {

                float farenheight;

                System.out.println("Enter temperatue in Fahrenheit: ");
                farenheight = input.nextInt();

                farenheight = ((farenheight - 32)*5)/9;

                System.out.println("Temperatue in Celsius = " + farenheight);

            } else if ( choice.equals("c") ) {

                float celsius;

                System.out.println("Enter temperatue in Celsius: ");
                celsius = input.nextInt();

                celsius = ((celsius)*18/10)+32;

                System.out.println("Temperatue in Farenheight = " + celsius);

            } else if ( choice.equals("i") ) {

                double inches;

                System.out.println("Enter length in Inches: ");
                inches = input.nextInt();

                inches = (inches/length);

                System.out.println("Length in Centimeters = " + inches);
            } else if ( choice.equals("ce") ) {

                double centimeters;

                System.out.println("Enter length in Centimeters: ");
                centimeters = input.nextInt();

                centimeters = (centimeters*length);

                System.out.println("Length in Inches is = " + length);
            }
            choice = input.nextLine();
            if ("redo".equals(choice)) {
                cont = true;
            } else {
                cont = false;
            }
        }
    }
}