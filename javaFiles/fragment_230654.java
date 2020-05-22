public static void main(String[] args) {
    int repeated[] = { 1, 4, 0, 0, 0, 3, 0, 0 };
    int hand[] = { 1, 2, 2, 2, 2, 6, 6, 6 };
    for (int z = 0; z < repeated.length; z++) {
        if (repeated[hand[z] - 1] >= 3) {
            hand[z] = 0;
        }
    }
    System.out.println(Arrays.toString(hand));
}