public static void main(String[] args) {
    Scanner input = new Scanner (System.in); //scanner

    short repeat = 1;
    while (repeat == 1) {


        System.out.println("Enter your equation by entering a, b, and c."); //introduction
        System.out.println("Press enter evey time you enter a number.");

        try {
            double a = Double.parseDouble(input.nextLine());
            double b = Double.parseDouble(input.nextLine());
            double c = Double.parseDouble(input.nextLine());

            double answer1 = ( (-b) + Math.sqrt( Math.pow(b, 2) - (4*a*c) ) ) / (2*a); //answers
            double answer2 = ( (-b) - Math.sqrt( Math.pow(b, 2) - (4*a*c) ) ) / (2*a);

            System.out.println("Your answers are: " + answer1 + " and " + answer2);
        }
        catch (NumberFormatException e) {
            System.out.println("That's not a valid number.");
        }



        System.out.println("Would you like to calculate more numbers? 1 for yes, 0 for no: ");
        repeat = Short.parseShort(input.nextLine());

    }
    input.close();

}