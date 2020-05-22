import javax.xml.bind.annotation.*;

@XmlTransient
public class Foo {

    private String att1;
    private String att2;

    @XmlAttribute
    public String getAtt1() {
        return att1;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }

}