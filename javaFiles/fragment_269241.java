public static List<Integer> fibonacci(int numero) {
    LinkedList<Integer> fibonacciSequence = new LinkedList<>();
    int numero1 = 0;
    int numero2 = 1;
    int fibonacci = 0;
    for (int i = 0; i <= numero; i++) {
        fibonacci = numero1 + numero2;
        numero1 = numero2;
        numero2 = fibonacci;
        fibonacciSequence.add(fibonacci);
    }
    return fibonacciSequence;
}