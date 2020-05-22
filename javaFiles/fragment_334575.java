public void printTriangle(int n) {
    if(n > 1) {
        printTriangle(n - 1);
    }
    System.out.println(makeStars(n));
}