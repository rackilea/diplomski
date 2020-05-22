public static void main (String[] args) {
    int[][] cities = {{-48,-4},{23,-45},{-7,-40},{-28,31},{36,24},{23,-11},{36,-10},{-9,21}};

    double maxDistance = 0;
    for (int i = 0; i < cities.length-1; i++) {
        for (int j = i+1; j < cities.length; j++) {
            maxDistance = Math.max(getDistance(cities[i], cities[j]), maxDistance);
        }
    }
    System.out.println("The max distance is " + maxDistance);
}

private static double getDistance(int[] city1, int[] city2) {
    int dx = city1[0] - city2[0];
    int dy = city1[1] - city2[1];
    return Math.sqrt(dx*dx + dy*dy);
}