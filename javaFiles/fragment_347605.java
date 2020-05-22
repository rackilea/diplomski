public void reverse() {
    System.out.println("Enter a valid 2-4 digit number: ");
    Scanner input = new Scanner(System.in);
    String value = input.next();
    int valueInt = Integer.parseInt(value);

    if (valueInt < 10 || valueInt > 9999){
        System.out.print("Please enter a valid 2-4 digit number: ")
        value = input.next();
    }

    String valueReversed = new StringBuilder(value).reverse().toString();

    System.out.println("Reversed numbers are: " + valueReversed);

}