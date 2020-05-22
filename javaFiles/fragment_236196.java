public static void main(String[] args) {
    // Stack<Integer> stack = new Stack<Integer>();  <-- error?
    Scanner sc = new Scanner(System.in);
    Stack myStak = new Stack(16);   // I broke at 3 at first test...
    System.out.println("Input : ");

    String input;
    while (true) {
        input = sc.next();    // let the Scanner deal with spaces and newlines
        String operator = input.substring(0, 1);
        if ("+-/*".contains(operator)) {  // is it an operator?
            int a = Integer.decode(myStak.pop()); // yes unpack and compute
            int b = Integer.decode(myStak.pop());
            int result = compute(a, b, operator);
            myStak.push(String.valueOf(result)); // push result back to stack and display
            System.out.println(a + " " + operator + " " + b + " = " + result);
        } else if ("=".equals(operator)) { // stop on =
            break;
        } else {
            myStak.push(input); // not an operator: assume a number and push it
        }
    }
}

// one single static function to avoid code duplication (DRY principle)
private static int compute(int i, int j, String op) {
    switch (op.charAt(0)) {
        case '+':
            return i + j;
        case '-':
            return i - j;
        case '*':
            return i * j;
        case '/':
            return i / j;
    }
    return 0;
}