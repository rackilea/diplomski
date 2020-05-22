package de.lhorn.so;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "myList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyList {

    private String name;

    private String type;

    private String version;

    public MyList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MyList{" + "name=" + name + ", type=" + type + ", version=" + version + '}';
    }

}