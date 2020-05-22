public static void main(String[] args) {
    System.out.println(Math.sqrt(quadraticFractionSum(1) * 6.0));
}
static double quadraticFractionSum(int counter) {
    if (counter == 1001) {
        return 0.0d;
    } else {
        return 1.0d / (counter * counter) + quadraticFractionSum(counter + 1);
    }
}