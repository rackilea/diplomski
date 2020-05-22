import javax.xml.bind.annotation.*;

@XmlRootElement
public class Foo {

    private Object object;

    @XmlAnyElement
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}