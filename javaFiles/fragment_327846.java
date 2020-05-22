public int getRandom() {
    Random random = new Random();
    int val = random.nextInt(10);

    if (val < 3) {
        return random.nextInt(50) + 1;      // random range 1 to 50
    }
    else {
        return random.nextInt(51) + 50;     // random range 50 to 100
    }
}