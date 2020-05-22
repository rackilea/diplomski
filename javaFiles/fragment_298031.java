import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
public class Test implements Callable {

@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
    eventContext.getMessage().getProperty("header1", PropertyScope.INBOUND);
    return null;
}
}