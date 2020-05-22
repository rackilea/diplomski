import javax.xml.bind.annotation.*;

@XmlRootElement
public class Bar extends Foo {

    @Override
    @XmlAttribute
    public String getAtt2() {
        return super.getAtt2();
    }

    @Override
    public void setAtt2(String att2) {
        super.setAtt2(att2);
    }

}