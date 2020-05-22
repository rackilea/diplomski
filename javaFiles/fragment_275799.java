void writeAreas(List<Area> areas, ObjectOutputStream stream)
throws IOException {
    List<Path2D> paths = new ArrayList<>(areas.size());
    for (Area area : areas) {
        paths.add(new Path2D.Float(area));
    }
    stream.writeObject(paths);
}