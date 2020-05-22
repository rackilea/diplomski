public static void main(String[] args) throws Exception {
    String a[] = {"12 + 34", "56 - 78", "99 * 99", "10 / 3"};
    stringProcess(a);
}

public static void stringProcess(String[] a) {
    for (int i=0; i < a.length; ++i) {
        String[] parts = a[i].split(" ");
        double operand1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double operand2 = Double.parseDouble(parts[2]);
        double result = 0.0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;

            case "-":
                result = operand1 - operand2;
                break;

            case "*":
                result = operand1 * operand2;
                break;

            case "/":
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Divide by zero!");
                }
                result = operand1 / operand2;
                break;
        }

        System.out.println(operand1 + " " + operator + " " + operand2 +
            " = " + String.format( "%.2f", result));
    }
}