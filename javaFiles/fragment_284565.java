private static void changeX() {

    Random generator = new Random();
    int x2 = generator.nextInt(10000) + 1;
    int y2 = generator.nextInt(10000) + 1;
    int z2 = generator.nextInt(10000) + 1;

    x = Math.min(Math.min(x2, y2), z2); // The Max of the 3 numbers

    z = Math.max(Math.max(x2, y2), z2); // The Min of the 3 numbers

    if (x != x2 && z != x2) { // The remaining middle number
        y = x2;
    } else if (x != y2 && z != y2) {
        y = y2;
    } else {
        y = z2;
    }

}