try {
    num1=input.nextInt();
    num2=input.nextInt();
    isValid=true;
} catch (InputMismatchException ex) { // catch the right exception
    System.out.println("Invalid input");
    // consume the previous, erroneous, input token(s)
    input.nextLine();
}