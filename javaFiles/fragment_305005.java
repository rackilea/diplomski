import org.eclipse.persistence.annotations.oxm.XmlPath;

class Data
{
    @XmlPath("Items/Item")
    private Item item;
}