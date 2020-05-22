@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
   @XmlElement(name="parent")
   List<Parent> allParents;
}