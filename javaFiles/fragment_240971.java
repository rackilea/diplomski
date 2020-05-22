package de.lhorn.so;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(name = "myList")
    private List<MyList> list = new ArrayList<>();

    public Root() {
    }

    public List<MyList> getList() {
        return list;
    }

    public void setList(List<MyList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Root{" + "list=" + list + '}';
    }

}