import java.io.Serializable;

public class Sensor implements Serializable
{

    private String id;
    private String name;
    private final static long serialVersionUID = 8244091126694748358L;

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

}