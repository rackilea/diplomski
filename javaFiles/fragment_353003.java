@ManagedBean
@ViewScoped
public class AddProjectToDB {

    @ManagedProperty(value = "#{markerLocationer}")
    private MarkerLocationer markerLocationer;

    public void setMarkerLocationer(MarkerLocationer markerLocationer) {
        this.markerLocationer = markerLocationer;
    }

    public void save() {

        double lat = markerLocationer.getMarkerPosition().getLat();
        double lon = markerLocationer.getMarkerPosition().getLng();

        //.. your stuff

    }
}