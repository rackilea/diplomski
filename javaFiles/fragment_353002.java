@ManagedBean
@SessionScoped
public class MarkerLocationer implements Serializable {

    private static final long serialVersionUID = 4288587129736579882L;

    private MapModel draggableModel;

    public MarkerLocationer(){
        draggableModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coord1 = new LatLng(41.017599, 28.985704);

        //Draggable
        draggableModel.addOverlay(new Marker(coord1, "Projenin olduğu yere sürükleyin."));

        for (Marker marker : draggableModel.getMarkers()) {
            marker.setDraggable(true);
        }
    }

    public MapModel getDraggableModel() {
        return draggableModel;
    }

    public void setDraggableModel(MapModel draggableModel) {
        this.draggableModel = draggableModel;
    }

    public void onMarkerDrag(MarkerDragEvent event) {
        // since marker's state is already kept in draggableModel you do not necessarily
    }

    public LatLng getMarkerPosition(){
        return draggableModel.getMarkers().get(0).getLatlng();
    }
}