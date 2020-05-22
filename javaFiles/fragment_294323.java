import java.util.List;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class XmlValidationHandler implements ValidationEventHandler {
    private final List<ValidationEvent> results;

    public XmlValidationHandler(List<ValidationEvent> results) {
        this.results = results;
    }

    @Override
    public boolean handleEvent(ValidationEvent event) {
        results.add(event);
        return true;
    }
}