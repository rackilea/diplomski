int limit = A * B;
for (int i = 1; i <= limit; i++) {
    System.out.print(i + " ");
    if (i % B == 0) {
        System.out.println();
    }
}