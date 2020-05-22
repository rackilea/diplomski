public void inputNumberOfEmployees () {
    Scanner input = new Scanner (System.in);
    try {
        System.out.print ("Enter the number of employees to input: ");
        numberOfEmployees = input.nextInt();
    }
    catch (InputMismatchException e) {
        System.out.println ("\nYou must enter an integer value. Please try agin\n");
        input.nextLine();
    }
}