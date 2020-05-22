public static void main(String[] args) {
    int sum = 1;
    for (int i = 2; i < 100; i++) {
        if (i % 2 == 0) {
            sum = sum + i;
        } else {
            sum = sum - i;
        }
    }
    System.out.println(sum);
}