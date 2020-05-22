@XmlRootElement(name="NotificationTemplateXMLList")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationTemplates {

     @XmlElement(name="NotificationTemplateXML")
     private List<NotificationTemplate>  notificationTemplates;
}