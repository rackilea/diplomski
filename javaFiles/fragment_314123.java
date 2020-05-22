import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

public class XopAwareMarshallingValidationEventHandler extends XopAwareValidationEventHandler {

  public XopAwareMarshallingValidationEventHandler(final ValidationEventHandler handler) {
    super(handler);
  }

  boolean isXopEvent(final ValidationEvent validationEvent) {
    final ValidationEventLocator locator = validationEvent.getLocator();
    return locator != null && locator.getNode() == null;
  }
}