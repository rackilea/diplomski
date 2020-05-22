import java.util.Random;

public class Test {

    static Random randomGenerator = new Random();
    static String operators = "+-*/P"; //p = parentheses pair

    public static char getRandomOperator() {
        return operators.charAt(randomGenerator.nextInt(operators.length()));
    }

    public static int getRandomNumber() {
        return randomGenerator.nextInt(100);
    }

    public static String createEquation() {
        //Just for proof of concept, let's do 3 operators
        String equation = "";
        int numOfOperators = 3;
        char operator = ' ';
        for (int i = 0; i < numOfOperators; i++) {
            equation += getRandomNumber();
            equation += getRandomOperator();
        }
        equation += getRandomNumber();
        return equation;
    }

    public static void main(String[] args) {
        String equation = createEquation();
        System.out.println(equation);
    }
}