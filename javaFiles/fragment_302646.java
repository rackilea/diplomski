import javax.xml.bind.*;

public class SubRequestValidator extends Unmarshaller.Listener implements ValidationEventHandler {

    private SubRequest subRequest;

    @Override
    public void beforeUnmarshal(Object target, Object parent) {
        if(target.getClass() == SubRequest.class) {
            subRequest = (SubRequest) target;
        } else {
            subRequest = null;
        }
    }

    public SubRequest getSubRequest() {
        return subRequest;
    }

    @Override
    public boolean handleEvent(ValidationEvent validationEvent) {
        if(subRequest != null) {
            System.out.println(subRequest.getId());
            System.out.println(validationEvent.getMessage());
        }
        return validationEvent.getSeverity() != ValidationEvent.FATAL_ERROR;
    }

}