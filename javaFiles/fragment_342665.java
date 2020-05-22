public static void main(String[] args) {
    String[] operators = {"-", "+", "*"};
    String operator;
    Random r = new Random();
    int result = -1;

    for (int i = 0; i < 3; i++) {
        int randNum = r.nextInt(9) + 1; // 1 - 9 inclusive
        if (i != 0) {
            operator = operators[r.nextInt(operators.length)];
            System.out.print(operator);
            result = calculate(result, randNum, operator);
        }
        else {
            result = randNum;
        }
        System.out.print(randNum);
    }
    System.out.println("=" + result);
}
public static int calculate(int operand1, int operand2, String operator) {
    switch (operator) {
        case "+":
            return operand1 + operand2;
        case "-":
            return operand1 - operand2;
        case "*":
            return operand1 * operand2;
        default:
            throw new RuntimeException();
    }
}