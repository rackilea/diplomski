public static void main(String[] args) {
    int array[][] = new int[5][];
    Random r = new Random();
    Random r2 = new Random();
    for (int i = 0; i < 5; i++) {
        int x = r.nextInt(10);
        array[i] = new int[x];
        for (int j = 0; j < x; j++) {
            int y = r2.nextInt(200);
            array[i][j] = y;
        }
    }
    for (int[] is : array) {
        for (int i : is) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    Random x = new Random();
    System.out.println(x.nextInt(10));
    System.out.println(x.nextInt(10));
}