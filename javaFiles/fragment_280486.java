static boolean isInfiniteOrNaN(double value) {
    return Double.isInfinite(value) || Double.isNaN(value);
}

public static void main(String args[]) throws IOException {
    System.out.println(isInfiniteOrNaN(Double.NaN)); //true
    System.out.println(isInfiniteOrNaN(Float.NaN)); //true
}