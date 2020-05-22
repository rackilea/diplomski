public class Track{
    private String id;
    private String name;
    private List<Pieces> pieces;
    private List<Lanes> lanes;
    private startingPoint startingPoint;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Pieces> getPieces() {
        return pieces;
    }
    public void setPieces(List<Pieces> pieces) {
        this.pieces = pieces;
    }
    public List<Lanes> getLanes() {
        return lanes;
    }
    public void setLanes(List<Lanes> lanes) {
        this.lanes = lanes;
    }
    public startingPoint getStartingPoint() {
        return startingPoint;
    }
    public void setStartingPoint(startingPoint startingPoint) {
        this.startingPoint = startingPoint;
    }
}