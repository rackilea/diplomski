package forum20127191;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="RootElement", namespace="http://example.com")
public class RootElement {

    private String foo;

    @XmlElement(namespace="http://example.com")
    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

}