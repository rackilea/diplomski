import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"required","optional"})
public class Foo {

    protected int required;
    protected Integer optional;

    public int getRequired() {
        return required;
    }

    public void setRequired(int value) {
        this.required = value;
    }

    public Integer getOptional() {
        return optional;
    }

    public void setOptional(Integer value) {
        this.optional = value;
    }

}