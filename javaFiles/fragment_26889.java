public int decrypt(int y) {
    if (y >= n) {
        System.out.println("N must be " + n + "-1");
    }

    if (y < a)
        return (y - a + n) % n;
    else
        return (y - a) % n;
}