public static void fibonacci(int numero) {
    int numero1 = 0;
    int numero2 = 1;
    int fibonacci = 0;
    for (int i = 0; i <= numero; i++) {
        fibonacci = numero1 + numero2;
        numero1 = numero2;
        numero2 = fibonacci;
        System.out.println(fibonacci);
    }
}