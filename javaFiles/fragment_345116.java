public class NamespacePrefixInterceptor extends AbstractPhaseInterceptor<Message> {
    public NamespacePrefixInterceptor() {
        super(Phase.PRE_STREAM);
        addBefore(SoapPreProtocolOutInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        if (isOutbound(message)) {
            OutputStream outputStream = message.getContent(OutputStream.class);
            CachedOutputStream cachedOutputStream = new CachedOutputStream();
            message.setContent(OutputStream.class, cachedOutputStream);
            message.getInterceptorChain().doIntercept(message);
            try {
                cachedOutputStream.flush();
                CachedOutputStream messageStream = (CachedOutputStream) message.getContent(OutputStream.class);
                String currentEnvelopeMessage = IOUtils.toString(messageStream.getInputStream(), "UTF-8");
                currentEnvelopeMessage = currentEnvelopeMessage.replaceAll("ns2:", "");
                currentEnvelopeMessage = currentEnvelopeMessage.replaceAll(":ns2", "");
                messageStream.flush();
                messageStream.close();
                InputStream replaceInStream = new ByteArrayInputStream(currentEnvelopeMessage.getBytes(StandardCharsets.UTF_8));
                IOUtils.copy(replaceInStream, outputStream);
                replaceInStream.close();
                outputStream.flush();
                message.setContent(OutputStream.class, outputStream);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isOutbound(Message message){
        return message == message.getExchange().getOutMessage()
            || message == message.getExchange().getOutFaultMessage();
    }
}