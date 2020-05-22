public class Line{
    (...)

    private List<Coordinates> coordinatesList = new ArrayList<Coordinates>;

    @XmlAttribute(name = "id")
    public String getId() {
        return id.get();
    }

    @XmlElement(name = "coordinates")
    public List<Coordinates> getCoordinatesList() {
        return coordinatesList;
    }



}