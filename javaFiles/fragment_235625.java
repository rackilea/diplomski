public static void main(String[] args) {

    ....

    OperationClass operationObject = new OperationClass();
    Scanner input = new Scanner(System.in);
    double userInput;
    userInput = input.nextDouble();
    operationObject.setFNum(userInput);
    userInput = input.nextDouble();
    operationObject.setSNum(userInput);

    ....
}