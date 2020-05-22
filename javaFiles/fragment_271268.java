public class SOAPLoggingHandler implements SOAPHandler {

        private static Logger logger = Logger.getLogger(SOAPLoggingHandler.class
                .getCanonicalName());

        public static final String REQUEST_XML="REQUEST_XML";


        @Override
        public boolean handleFault(SOAPMessageContext context) {

            writeMessageLogging(context);
            return true;
        }

        @Override
        public boolean handleMessage(SOAPMessageContext context) {
            writeMessageLogging(context);
            return true;

        }

        private void writeMessageLogging(SOAPMessageContext smc) {
            Boolean outboundProperty = (Boolean) smc
                    .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

            SOAPMessage message = smc.getMessage();
            ByteArrayOutputStream out=null;
            try {
                 out = new ByteArrayOutputStream();
                 message.writeTo(out);
                 String strMsg = new String(out.toByteArray());

                if (!outboundProperty.booleanValue()) {
                    String requestXML=(String)smc.get(REQUEST_XML);
                    logger.debug("Request of Response:"+requestXML);
                }else{
                    smc.put(REQUEST_XML,strMsg);
                }
                logger.debug("strMsg:" + strMsg);
                out.close();
            } catch (Exception e) {
                logger.error("Exception in handler:", e);
            }finally{
                IOUtils.closeQuietly(out);
            }

        }
    }