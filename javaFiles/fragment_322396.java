public class FormattedJAXBInterceptor extends AbstractPhaseInterceptor<Message> {
    public FormattedJAXBInterceptor() {
        super(Phase.PRE_STREAM);
    }

    public void handleMessage(Message message) {
        message.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    public void handleFault(Message messageParam) {
        message.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }
}