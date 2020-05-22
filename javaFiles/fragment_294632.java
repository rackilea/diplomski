import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Foo {

    private Bar bar;

    @XmlAnyElement
    @XmlJavaTypeAdapter(BarAdapter.class)
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

}