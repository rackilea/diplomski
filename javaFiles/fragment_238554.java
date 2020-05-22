import java.util.ArrayList;
import java.util.List;

public class Row {
    private Boolean status;
    private List<Subarea> subareas = new ArrayList<Subarea>();
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public List<Subarea> getSubareas() {
        return subareas;
    }
    public void setSubareas(List<Subarea> subareas) {
        this.subareas = subareas;
    }
    @Override
    public String toString() {
        return "Row [status=" + status + ", subareas=" + subareas + "]";
    }
}