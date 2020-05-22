public static void computerMove(int stone1, int stone2, int stone3) {
    Random randA = new Random();
    int pcPilePick = randA.nextInt(10);

    Object amtInPile;
    if (pcPilePick == 1) {
        amtInPile = stones1;
    }
    if (pcPilePick == 2) {
        amtInPile = stones2;
    }
    if (pcPilePick == 3) {
        amtInPile = stones3;
    }
}