package forum9137171;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "foo")
public class FooImpl implements Foo {
    private String id;
    private String name;

    @XmlElement
    public String getName() {
            return name;
    }

    public void setName(final String name) {
            this.name = name;
    }

    @XmlAttribute
    public String getId() {
            return id;
    }

    public void setId(final String id) {
            this.id = id;
    }
}