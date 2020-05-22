package JAXBImpl;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Java {

    @XmlElement(name="field")
    private List<Field> fields;

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Field {

    @XmlElement(name="map")
    private MapNode mapNode;

    @XmlElement(name="string")
    private StringNode stringNode;

    @XmlAttribute
    private String name;

    public MapNode getMapNode() {
        return mapNode;
    }

    public void setMapNode(MapNode mapNode) {
        this.mapNode = mapNode;
    }

    public StringNode getStringNode() {
        return stringNode;
    }

    public void setStringNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class StringNode {
    @XmlAttribute
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class MapNode {

    @XmlElement(name="entry")
    List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }   
}

@XmlAccessorType(XmlAccessType.FIELD)
class Entry {

    @XmlElement(name="key")
    private Key key;

    @XmlElement(name="value")
    private Value value;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Key {

    @XmlElement(name="string") 
    StringNode stringNode;

    public StringNode getStringNode() {
        return stringNode;
    }

    public void setStringNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Value {
    @XmlElement(name="string") 
    private StringNode stringNode;

    public StringNode getStringNode() {
        return stringNode;
    }

    public void setStringNode(StringNode stringNode) {
        this.stringNode = stringNode;
    }
}

public class Main {

    public static void main (String args []) 
    throws Exception
    {
        File file = new File("test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Java.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Java java = (Java) jaxbUnmarshaller.unmarshal(file);
        for(Field field : java.getFields()) {
            System.out.println("-----------------------------------------------");
            System.out.println("Field Name = " + field.getName());
            if(field.getStringNode() != null) {
                System.out.println("String Value = " + field.getStringNode().getValue());
            }

            if(field.getMapNode() != null) {
                for(Entry entry : field.getMapNode().getEntries()) {
                    System.out.println("Key = " + entry.getKey().getStringNode().getValue());
                    System.out.println("Value = " + entry.getValue().getStringNode().getValue());
                }
            }
        }
    }      
}