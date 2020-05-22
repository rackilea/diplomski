public static void main(String[] args) {
    int COUNT = 3;
    for (int i=0; i<12; i++) {
        if (i + COUNT > 12) {
            System.out.println(i + COUNT - 12);
        } else {
            System.out.println(i + COUNT);
        }
    }
}