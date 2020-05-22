@JsonIgnoreProperties(ignoreUnknown = true)
public class Passes {
    private List<Info> info;  

    public Passes() {
        // TODO Auto-generated constructor stub
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }
}