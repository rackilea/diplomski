public static int factorial(int num) {
    if (num == 0) {
        System.out.println("In f(0) and computing f(0). Returning 1");
        return 1;
    }

    System.out.printf("In f(%d) and calling f(%d) . . .%n", num,
                num - 1);  // #1

    int factorial = factorial(num - 1);
    int result = num * factorial;

    System.out.printf(
        "f(%1$d) is %1$d * %2$d which equals %3$d. Returning %3$d%n",
            num, factorial, result);  // #2

    return result;
}