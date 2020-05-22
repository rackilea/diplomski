public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // while (true) just for testing
    while (true) {
        try {
            System.out.print("Enter a float: ");
            System.out.println(CheckFloat(input));
        } catch (MyException me) {
            System.out.println(me.toString());
        }
    }
}

private static float CheckFloat(Scanner sc) throws MyException {
    try {
        float input = sc.nextFloat();
        if (input % 1 == 0) {
            throw new MyException("Wrong type");
        } else {
            return input;
        }
    } catch (InputMismatchException ime) {
        sc.next(); // Flush the scanner

        // Rethrow your own exception
        throw new MyException("Wrong type");
    }
}

private static class MyException extends Exception {
    // You exception details
    public MyException(String message) {
        super(message);
    }
}