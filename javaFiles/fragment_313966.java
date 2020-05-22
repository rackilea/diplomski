package forum13272288;

import java.util.*;
import javax.xml.bind.annotation.XmlAnyElement;

public class Wrapper<T> {

    private List<T> items = new ArrayList<T>();

    @XmlAnyElement(lax=true)
    public List<T> getItems() {
        return items;
    }

}