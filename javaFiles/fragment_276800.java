private static void smallestPrime() {
long m = 0;

int[] b = { 2, 3, 4, 5, 6, 7, 8 };

for (int j = 0; j <= 6; j++) {

    m = (long) Math.pow(38, j) + 31;
    boolean prime = true;
    for (int i = 0; i <= 6; i++) {
    if (m % b[i] == 0) {
        prime = false;
        break;
    }
    }
    System.out.println(m + " : " + prime);
}
}