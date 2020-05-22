public static void main(String[] args) throws Exception {
    while (true) {
        System.out.print("Enter a float: ");
        try {
            float myFloat = input.nextFloat();
            if (myFloat % 1 == 0) {
                throw new Exception("Wrong type");
            }
            System.out.println(myFloat);
        } catch (InputMismatchException ime) {
            System.out.println(ime.toString());
            input.next(); // Flush the buffer from all data
        }
    }
}