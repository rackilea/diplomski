public class Testor4 {
public static void main(String[] args) {
    String s1 = getInput("Enter a number: ");
    String s2 = getInput("Enter second number");
    String op = getInput("Enter operator: + - / * ");
    double result = 0;
    String str = " You chose to";
    try {
        switch (op) {
        case "+":
            str += getOpName(op);
            result = getSum(s1, s2);
            break;
        case "-":
            str += getOpName(op);
            result = getSub(s1, s2);
            break;
        case "/":
            str += getOpName(op);
            result = getDiv(s1, s2);
            break;
        case "*":
            str += getOpName(op);
            result = getMult(s1, s2);
            break;
        default:
            System.out.println("not an operator.");
            return;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    System.out.printf("%s%s%.2f", "Result is: ", str, result);
}

private static double getSum(String s1, String s2) {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    return d1 + d2;
}

private static double getSub(String s1, String s2) {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    return d1 - d2;
}

private static double getDiv(String s1, String s2) {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    return d1 / d2;
}

private static double getMult(String s1, String s2) {
    double d1 = Double.parseDouble(s1);
    double d2 = Double.parseDouble(s2);
    return d1 * d2;
}

public static String getOpName(String op) {
    String opName = "not an operator.";
    switch (op) {
    case "+":
        opName = " ADD!";
        break;
    case "-":
        opName = " Subtract!";
        break;
    case "/":
        opName = " Divide!";
        break;
    case "*":
        opName = " Multiply!";
        break;
    }
    return opName;
}

public static String getInput(String prompt) {
    System.out.println(prompt);
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
}