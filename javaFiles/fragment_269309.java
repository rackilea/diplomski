import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlJavaTypeAdapter(MyAdapter.class)
public class A {

    private B b;
    private List<C> c;

    public A() {
        c = new ArrayList<C>();
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public List<C> getC() {
        return c;
    }

    public void setC(List<C> c) {
        this.c = c;
    }

}