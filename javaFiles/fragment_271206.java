package forum20127191;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="RootElement")
public class RootElement {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

}