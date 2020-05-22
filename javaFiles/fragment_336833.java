public void choice() throws InputMismatchException {
    Scanner s = new Scanner(System.in);
    int option = 0;

    try {
        option = s.nextInt();
    } catch (InputMismatchException e) {
        throw new InputMismatchException("Enter valid input");
    }

    if (option == 1) {
        System.out.println("e");
    } else if (option == 2) {
        System.out.println("f");
    } else if (option == 3) {
        System.exit(0);
    } else {
        throw new InputMismatchException("Enter valid input");
    }

}

public static void main(String[] args) {
    try {
        new Test().choice();
    } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
    }
}