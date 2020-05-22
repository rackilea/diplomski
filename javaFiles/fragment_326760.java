import javax.xml.bind.annotation.XmlElement;

public class Node {

    @XmlElement
    private String id;

    @XmlElement
    private String stencil;

    public Node() {
    }

    public Node(String id, String stencil) {
        this.id = id;
        this.stencil = stencil;
    }

    public String getId() {
        return id;
    }

    public String getStencil() {
        return stencil;
    }
}