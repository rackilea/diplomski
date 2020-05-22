import javax.xml.bind.JAXBException;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class CustomOutInterceptor extends AbstractPhaseInterceptor<Message> {


    @Override
    public void handleMessage(Message message) throws Fault {
        //do something with your message here
    }
    public CustomOutInterceptor() {
        super(Phase.POST_LOGICAL);
    }
}