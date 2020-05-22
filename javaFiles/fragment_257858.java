public static void main(String[] args) throws Exception {
    Random rand = new Random();

    int headCount = 0;
    int tailCount = 0;

    for (int i = 0; i < 10; i++) {
        int value = rand.nextInt(2);

        if (value == 0) {
            System.out.println("Heads");
            headCount++;
        } else {
            System.out.println("Tails");
            tailCount++;
        }
    }

    System.out.println("Head Count: " + headCount);
    System.out.println("Tail Count: " + tailCount);

}