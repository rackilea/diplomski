public static void main(String[] args) {
    for (int c = 32; c < 123; c++) {
        System.out.print((char) c);
        if ((c - 31) % 10 == 0) {
            System.out.println();
        }
    }
}