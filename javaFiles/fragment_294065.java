public void inputNumberOfEmployees () {
    Scanner input = new Scanner (System.in);

    boolean isInvalid = true;
    while (isInvalid) {

        try {
            System.out.print ("Enter the number of employees to input: ");
            numberOfEmployees = input.nextInt();

            isInvalid = false;
        }
        catch (InputMismatchException e) {
            System.out.println ("\nYou must enter an integer value.\n");
        }

    }
}