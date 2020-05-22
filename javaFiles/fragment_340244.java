public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    System.out.println("Ingrese el numero N");
    int n = teclado.nextInt();
    for (int i = 1; i <= n; i++){
        double d = Math.random();
        System.out.println(d);
    }
}