import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = { "foo", "bar" })
public class Root {

    private Date foo;
    private Date bar;

    public Date getFoo() {
        return foo;
    }

    public void setFoo(Date foo) {
        this.foo = foo;
    }

    public Date getBar() {
        return bar;
    }

    public void setBar(Date bar) {
        this.bar = bar;
    }

}