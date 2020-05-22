import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageTypes;

public class SMSInNotification implements IInboundMessageNotification
{   
    public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg)
    {
        switch (msgType)
        {
            case INBOUND:
                System.out.println(">>> New Inbound message detected from " + "+" + msg.getOriginator() + " " + msg.getText());
                break;
            case STATUSREPORT:

                break;
        }
    }
}