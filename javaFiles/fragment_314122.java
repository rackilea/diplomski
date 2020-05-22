import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

class XopAwareUnmarshallingValidationEventHandler extends XopAwareValidationEventHandler {

  private static final String XOP_INCLUDE = "xop:Include";

  XopAwareUnmarshallingValidationEventHandler(final ValidationEventHandler handler) {
    super(handler);
  }

  @Override
  boolean isXopEvent(final ValidationEvent validationEvent) {
    final ValidationEventLocator locator = validationEvent.getLocator();
    return locator != null && locator.getNode() != null &&
        locator.getNode().getFirstChild() != null &&
        XOP_INCLUDE.equals(locator.getNode().getFirstChild().getNodeName());
  }
}