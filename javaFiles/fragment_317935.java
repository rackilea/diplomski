@XmlRootElement    
@XmlAccessorType(XmlAccessType.FIELD)
public class MyXMLObjectRepresentation {
     @XmlElement
     @XmlJavaTypeAdapter(DateXmlMigrateAdapter.class)
     private Date date;

     public Date getDate() {
         return date;
     }
}