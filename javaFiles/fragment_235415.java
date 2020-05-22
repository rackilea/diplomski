//input contains the expression user has entered
public static int evaluateEXP(Scanner scanner) {
    //checks if there is another digit after current one
    //allows expression to be looked at from right to left
    if (scanner.hasNextInt())
        return scanner.nextInt();

    //if there is another digit after current one then
    //operands and operators are established
    char operator = scanner.next().charAt(0);
    return evaluateOP(operator, scanner);
}

//operator has to be one of +, - , * or ! otherwise error is given
private static int evaluateOP(char operator, Scanner scanner) {
    if (operator == '+')
        return evaluateEXP(scanner) + evaluateEXP(scanner);
    if (operator == '-')
        return evaluateEXP(scanner) - evaluateEXP(scanner);
    if (operator == '*')
        return evaluateEXP(scanner) * evaluateEXP(scanner);
    if (operator == '/')
        return evaluateEXP(scanner) / evaluateEXP(scanner);
    if (operator == '!')
        //if ! used then uses factorial method
        return factorial(evaluateEXP(scanner));
    //RunTimeException allows to return an error string in a int "type" method
    throw new RuntimeException("operator not allowed for this language");
}