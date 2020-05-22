private static int getRandomNumber(int a, int b) {
    if (b < a)
        return getRandomNumber(b, a);
    return a + (int) ((1 + b - a) * Math.random());
}

public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
        System.out.format("%d ", getRandomNumber(-100, 100));
    }
}