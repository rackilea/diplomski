public class ServerThread extends Thread {
    public void run() {
        String sDataFromPOS="";
        //Get Some Value in sDataFromPOS
        SAXHandler handler = new SAXHandler();
        byte[] bSendToPOS = handler.parseXMLToString(sDataFromPOS.toString().substring(2));
        handler.sTerminalId .... // access instance variables
    }
}

public class SAXHandler extends DefaultHandler {
    String sTerminalId = "";
    String sTransactionId = "";

    public byte[] parseXMLToString(String sXMLData) throws Throwable {
        /* Do Some Operation on String sXMLData & extarct value of sTerminalId & sTransactionId*/
    }
}