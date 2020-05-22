import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

String xmlString = "above xml string"
try {
    Serializer serializer = new Persister();
    NotificationModel notificationModel = serializer.read(NotificationModel.class, xmlString);
    //TODO: Use notificationModel's variables with filled values
} catch (Exception e) {
    e.printStackTrace();
}