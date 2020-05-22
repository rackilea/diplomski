List<Area> readAreas(ObjectInputStream stream)
throws IOException, ClassNotFoundException {
    List<?> paths = (List<?>) stream.readObject();
    List<Area> areas = new ArrayList<>(paths.size());
    for (Object pathObj : paths) {
        Shape path = (Shape) pathObj;
        areas.add(new Area(path));
    }
    return areas;
}