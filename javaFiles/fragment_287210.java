public static int factorial (int number) {
    int result = 1;
    if (number < 1 || number > 10)
    {
        System.out.println("Invalid!! the number has to be between 1 and 10");
        throw new IllegalArgumentException("Factorial input has to be between 1 and 10");
    }

    // rest of your code....
}