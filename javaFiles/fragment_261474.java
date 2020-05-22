public class ws1TI {
    public static class WS1TI implements Runnable {
        @Override
        public void run() {
            try {
                 SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
                 SOAPConnection soapConnection = soapConnectionFactory.createConnection();
                 String url = "http://*********.asmx?WSDL";
                 SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
                 printSOAPResponse(soapResponse);
                 updateAcknoledgement();
            }
            catch (Exception e) {
                 e.printStackTrace();
                 System.err.println(e.toString());
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();   
        final ScheduledFuture<?> timeHandle = 
            scheduler.scheduleAtFixedRate(new WS1TI(), 0L, 10L, TimeUnits.MINUTE); 
    }
}