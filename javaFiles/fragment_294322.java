import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ValidationEvent;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class ValidatingInterceptor extends AbstractPhaseInterceptor<Message> {

    public static String CTX_KEY_VALIDATOR_EVENTS = "event_key";

    public ValidatingInterceptor() {
        super(Phase.READ);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        List<ValidationEvent> validationRes = new ArrayList<ValidationEvent>();
        message.put(CTX_KEY_VALIDATOR_EVENTS, validationRes);
        message.setContextualProperty("jaxb-validation-event-handler", new XmlValidationHandler(validationRes));
    }
}