public static void main(String[] args) {
    getInput("Escribe un dato de tipo boolean opciones son (true/false: ", Scanner::nextBoolean, "Tipo Booleado: ");
    getInput("Escribe un tipo de dato byte : ", Scanner::nextByte, "Tipo Byte: ");
    //...other questions
}


/**
 * Goes to get input from stdin
 * @param inputQuestion The input question for user
 * @param inputHandler The user's input handler function
 * @param outputLabel The output label to show to the user
 * @param <T> The generic input object returned by scanner
 */
private static <T> void getInput(String inputQuestion, Function<Scanner, T> inputHandler, String outputLabel) {
    Scanner scan = new Scanner(System.in);
    try {
        System.out.println(inputQuestion);
        System.out.println(outputLabel + " " + inputHandler.apply(scan));
    } catch (InputMismatchException e) {
        //TODO: handle exception
        System.out.println("Dato ingresado no es correcto");
    }
}