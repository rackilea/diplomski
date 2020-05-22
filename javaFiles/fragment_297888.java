@ManagedBean
@ViewScoped
public class MapBean implements Serializable {  

    private MapModel mapModel;  
    private String title;  
    private double lat;  
    private double lng;  
    private String input;

    public MapBean() {  
        mapModel = new DefaultMapModel();  
    }  

    public void addMarker(ActionEvent actionEvent) {  
        mapModel.addOverlay(new Marker(new LatLng(lat, lng), title));  
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));  
    }  

    public void submit() {
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Form submitted", "Amount markers: " + mapModel.getMarkers().size() + ", Input: " + input));
    }

    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  

    // Getters+setters.
}