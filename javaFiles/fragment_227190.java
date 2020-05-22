public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int b, result;

    System.out.println("Enter the equation:");

    result = input.nextInt();

    while (true) {

        String c = input.next();
        if (c.contains(".")) {
            break;
        }

        b = input.nextInt();

        if (c.contains("+")) {
            result = add(result, b);
        } else if (c.contains("*")) {
            result = multiply(result, b);
        } else if (c.contains("/")) {
            result = divide(result, b);
        } else if (c.contains("-")) {
            result = subtract(result, b);
        } else if (c.contains("%")) {
            result = modulus(result, b);
        } 
    }
    input.close();

    System.out.print("The solution to your equation is: " + result);

}