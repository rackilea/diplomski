@Entity
public class EndpointUpdateRequestBody {
    // Since Google Cloud Endpoints doesn't support HTTP PATCH, we are overloading
    // HTTP PUT to do something similar.
    private Map<String, String> patchFieldsOps;

    public EndpointUpdateRequestBody() {
        patchFieldsOps = new HashMap<String, String>();
    }

    public EndpointUpdateRequestBody(Map<String, String> patchFieldsOps) {
        this.patchFieldsOps = patchFieldsOps;
    }

    public Map<String, String> getPatchFieldsOps() {
        return patchFieldsOps;
    }

    public void setPatchFieldsOps(Map<String, String> patchFieldsOps) {
        this.patchFieldsOps = patchFieldsOps;
    }
}