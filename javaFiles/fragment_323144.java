private void removeDuplicates() {
    Set<Point> distinctPoints = new HashSet<>();
    for (Point p : points) {
        distinctPoints.add(p);
    }
    points = new ArrayList<String>(distinctPoints);
}