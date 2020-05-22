public static int randInt(int min, int max) {
    //you can initialize your Random in a number of different ways. This is just one.
    Random rand = new Random();

    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}