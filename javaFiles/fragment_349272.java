JSONObject main = new JSONObject();

List<Point> points = new ArrayList<>();
points.add(new Point("point1", 1, 2, 3));
points.add(new Point("point2", 2, 3, 4));

JSONObject pointsAsJson = new JSONObject();
for (Point p : points) {
    JSONObject coordinates = new JSONObject();
    coordinates.put("x", p.getX());
    coordinates.put("y", p.getY());
    coordinates.put("z", p.getZ());
    pointsAsJson.put(p.getName(), coordinates);
}

main.put("main", pointsAsJson);