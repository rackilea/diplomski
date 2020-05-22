public class CleartextLogger extends AbstractSoapInterceptor {
    private static final String LOG_SETUP = CleartextLogger.class.getName() + ".log-setup";
    private Logger logger;

    public CleartextLogger(Logger logger) {
        super(Phase.POST_PROTOCOL);
        this.logger = logger;
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        try {
            boolean logged = message.containsKey(LOG_SETUP);
            if (!logged) {
                message.put(LOG_SETUP, Boolean.TRUE);
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                SOAPMessage smsg = message.getContent(SOAPMessage.class);
                if(smsg != null)  {
                    smsg.writeTo(bout);
                    log(bout.toString());
                } else {
                    logger.warn("Es gab keinen verschlüsselten Inhalt zu loggen");
                }
            }
        } catch (SOAPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void log(String xml) {
        StringReader in = new StringReader(xml);
        StringWriter swriter = new StringWriter();
        XMLStreamWriter xwriter = StaxUtils.createXMLStreamWriter(swriter);
        xwriter = new PrettyPrintXMLStreamWriter(xwriter, 2);
        try {
            StaxUtils.copy(new StreamSource(in), xwriter);
        } catch (XMLStreamException xse) {
            //ignore
        } finally {
            try {
                xwriter.flush();
                xwriter.close();
            } catch (XMLStreamException xse2) {
                //ignore
            }
            in.close();
        }

        String result = swriter.toString();
        logger.debug(result);
    }
}