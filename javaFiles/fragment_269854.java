import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "myStringElementName",
    "myIntElementName"
})
@XmlRootElement(name = "foo")
public class Foo {

    @XmlElement(nillable = true)
    protected String myStringElementName;
    @XmlElement(nillable = true)
    protected Integer myIntElementName;

    public String getMyStringElementName() {
        return myStringElementName;
    }

    public void setMyStringElementName(String value) {
        this.myStringElementName = value;
    }

    public Integer getMyIntElementName() {
        return myIntElementName;
    }

    public void setMyIntElementName(Integer value) {
        this.myIntElementName = value;
    }

}