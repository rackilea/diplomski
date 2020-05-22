public interface IsendMessage<T extends MessageContext> {
    public void send(T context);
}

public interface MessageContext {

};

public class SMSMessageContext implements MessageContext{}

public class SMSSender implements IsendMessage<SMSMessageContext>{

    @Override
    public void send(SMSMessageContext context) {

    }

}