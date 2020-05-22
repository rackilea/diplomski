import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "notification", strict = false)
public class NotificationModel {

    @Element(name = "code")
    public String errorCode;

    @Element(name = "message")
    public String errorMessage;
}