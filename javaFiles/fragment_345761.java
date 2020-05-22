public class MessageListenerImpl implements MessageListener {
    private static Logger logger = Logger.getLogger(MessageListenerImpl.class);

    public void message(XdmNode content, boolean terminate, SourceLocator locator) {
        if (terminate) {
            logger.error(content.getStringValue());
            System.exit(1);
        } else {
            logger.warn(content.getStringValue());
        }
    }
}