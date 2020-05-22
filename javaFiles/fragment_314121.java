import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

abstract class XopAwareValidationEventHandler implements ValidationEventHandler {

  private static final String CVC_TYPE_3_1_2 = "cvc-type.3.1.2";

  private ValidationEventHandler realHandler;

  XopAwareValidationEventHandler(final ValidationEventHandler handler) {
    this.setRealHandler(handler);
  }

  @Override
  public boolean handleEvent(final ValidationEvent event) {
    final boolean result = this.getRealHandler().handleEvent(event);
    if (!result) {
      if (event.getMessage() != null && event.getMessage().startsWith(CVC_TYPE_3_1_2)) {
        return this.isXopEvent(event);
      }
    }
    return result;
  }

  abstract boolean isXopEvent(ValidationEvent validationEvent);

  private ValidationEventHandler getRealHandler() {
    return realHandler;
  }

  private void setRealHandler(final ValidationEventHandler realHandler) {
    this.realHandler = realHandler;
  }
}