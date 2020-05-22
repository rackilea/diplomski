public static double fastPotRek(double x, int n) {
    return new Cloneable() {
        private double aux(double x, int n, int c) {
            if (n == 0) {System.out.print("It took "+c+" recursive calls to compute "); return 1;}
            else return (n % 2 == 0) ? aux(x*x, n/2, c+1) : x * aux(x, n-1, c+1);
        }
    }.aux(x, n, 0);
}