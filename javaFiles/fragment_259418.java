public class MyAPI {
    private Set<Polygon> polygons = new HashSet<Polygon>();
    private Set<Polygon> polygonsReadonlyView = Collections.unmodifiableSet(polygons);
    public Set<Polygon> getPolygons() {
        return polygonsReadonlyView;
    }
    public boolean addPolygon(Polygon p) {
        if (p == null) {
            throw new IllegalArgumentException("polygon cannot be null");
        }
        return polygons.add(p);
    }
    public boolean removePolygon(Polygon p) {
        return polygons.remove(p);
    }
    public void clearPolygons() {
        polygons.clear();
    }
}