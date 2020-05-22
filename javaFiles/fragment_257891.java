public static void main(String[] args) {
    long a = 123456789012345678L, b = 876543210987654321L;

    long start = System.currentTimeMillis();

    long score = getCount(b) - getCount(a - 1);

    System.out.println("Time: " + ((System.currentTimeMillis() - start)));
    System.out.println("Divisible by 2 or 3 or 5: " + score);
}

public static long getCount(long end) {
    return (end / 2) + (end / 3) + (end / 5) - ((end / 6)  + (end / 10) + (end / 15)) + (end / 30);
}