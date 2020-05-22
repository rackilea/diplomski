import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ProDesc {

    private int id;

    public ProDesc(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}