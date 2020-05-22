package forum15875338;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

    private String foo;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

}