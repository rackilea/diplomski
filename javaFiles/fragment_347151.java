import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Item {

    private String itemID;
    private String itemDescription;

    // need to have a constructor with no params
    public Item() {}

    public Item(String itemID, String itemDescription) {
        this.itemID = itemID;
        this.itemDescription = itemDescription;
    }

    @XmlAttribute
    public String getId() {
        return itemID;
    }

    public void setId(String id) {
        itemID = id;
    }

    @XmlElement
    public String getDescription() {
        return itemDescription;
    }

    public void setDescription(String description) {
        itemDescription = description;
    }
}