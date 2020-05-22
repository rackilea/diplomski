public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter The Expression: ");     
    int answer = 0, num = 0, input1, input2;
    char operator = '+' ;

    /* Read Input 1 */
    input1 = input.nextInt();

    //this loop will continue until ? is entered
    do {
        /* Read Operator */
        operator = input.next().charAt(0);
        if(operator == '?') break;
        /* Read Input 2 */
        input2 = input.nextInt(); 
        // this will detect which operator is used 
        switch (operator) {
            case '+': answer = addition(input1, input2);
                      break;
            case '-': answer = subtract(input1, input2);
                      break;
            case '*': answer = multiply(input1, input2);
                      break;
            case '/': answer = division(input1, input2);
                      break;
            case '%': answer = remainder(input1, input2);
        }
        /* Input1 will be the answer now */
        input1 = answer;
    } while (operator != '?'); 
    System.out.println("Result: " + answer);   
}

// this is the math if a + is used as an operator
static int addition (int num1, int num2){
    int add;
    add = num1 + num2;
    return add;
}
// this is the math if a - is used as an operator
static int subtract (int num1, int num2){
    int minus;
    minus = num1 - num2;
    return minus;
}
// this is the math if a * is used as an operator
static int multiply (int num1, int num2){
    int multi;
    multi = num1 * num2;
    return multi;
}
// this is the math if a / is used as an operator
static int division (int num1, int num2){
    int div;
    div = num1 / num2;
    return div;
}
// this is the math if a % is used as an operator
static int remainder (int num1, int num2){
    int modulos;
    modulos = num1 % num2;
    return modulos;
}