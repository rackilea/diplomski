@XmlRootElement(name="Class", namespace="http://MyNameSpace/")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassWithASoLongNameThatIWantToRenameIt {

     @XmlElement(name="Property")
     private String propertyWithASoLongNameThatIWantToRenameIt;

     public String getPropertyWithASoLongNameThatIWantToRenameIt {
           return propertyWithASoLongNameThatIWantToRenameIt;
     }