private Point translate(Location location, Point origin, int distance) {
    Point result = (Point)origin.clone();
    location.translate(result, distance);
    return result;
}

rndRect.setLocation(translate(StartButt.getLocation(), buttW, 2));