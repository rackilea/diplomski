final double num1 = Double.parseDouble(FirstInput.getText());
final double num2 = Double.parseDouble(SecondInput.getText());
final String oper = (Operator.getText());
final DoubleBinaryOperator operator;
switch(oper){
    case "+": 
        operator = (a, b) -> a+b;
        break;
    case "-": 
        operator = (a, b) -> a-b;
        break;
    case "/": 
        operator = (a, b) -> a/b;
        break;
    case "x": 
        operator = (a, b) -> a*b;
        break;
    default:
        throw new UnsupportedOperationException();
}

setAnswerText(num1, num2, operator);