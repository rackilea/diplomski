package forum9137171;

import java.util.List;  
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "foos")
public class Foos {

    private List<Foo> foos;

    @XmlElement(name = "foo", type=FooImpl.class)
    public List<Foo> getFoos() {
        return foos;
    }

    public void setFoos(List<Foo> foos) {
        this.foos = foos;
    }

}