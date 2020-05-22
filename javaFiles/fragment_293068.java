public static void main(String[] args) {

    int startAt = 2;

    for (int i = startAt; i <= 10; i += 2) {
        for (int j = startAt; j <= 10; j += 2) {
            System.out.print(i*j + "\t");
        }
        System.out.println();
    }
}