import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder={"fooString", "barString", "fooJAXBElement", "barJAXBElement"})
public class Root {

    private String fooString;
    private String barString;
    private JAXBElement<String> fooJAXBElement;
    private JAXBElement<String> barJAXBElement;

    private boolean setFoo;
    private boolean setBar;

    @XmlElement(nillable=true)
    public String getFooString() {
        return fooString;
    }

    public void setFooString(String foo) {
        this.fooString = foo;
        this.setFoo = true;
    }

    public boolean isSetFooString() {
        return setFoo;
    }

    @XmlElement(nillable=true)
    public String getBarString() {
        return barString;
    }

    public void setBarString(String bar) {
        this.barString = bar;
        this.setBar = true;
    }

    public boolean isSetBarString() {
        return setBar;
    }

    @XmlElementRef(name="fooJAXBElement")
    public JAXBElement<String> getFooJAXBElement() {
        return fooJAXBElement;
    }

    public void setFooJAXBElement(JAXBElement<String> fooJAXBElement) {
        this.fooJAXBElement = fooJAXBElement;
    }

    @XmlElementRef(name="barJAXBElement")
    public JAXBElement<String> getBarJAXBElement() {
        return barJAXBElement;
    }

    public void setBarJAXBElement(JAXBElement<String> barJAXBElement) {
        this.barJAXBElement = barJAXBElement;
    }

}