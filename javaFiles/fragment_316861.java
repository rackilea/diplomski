public static double fallingDistance(int varTime) {

    double gravity = 9.8;
    double distance = Math.pow((0.5 * gravity * varTime), 2);
    System.out.println(gravity);
    return distance;
}