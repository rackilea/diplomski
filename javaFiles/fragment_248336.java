@XmlRootElement(name="ResultCollection")
public class ResultCollectionResponse
{
    @XmlElementWrapper(name="FailedItems")
    @XmlElement(name = "KeyValueOflongstring", namespace="http://schemas.microsoft.com/2003/10/Serialization/Arrays")
    public List<KeyValueOflongstring> FailedItems = new ArrayList<KeyValueOflongstring>();

    @XmlElementWrapper(name="SucceededItems")
    @XmlElement(name = "long")
    public List<Long> SucceededItems = new ArrayList<Long>();
}