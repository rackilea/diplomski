public class SequenceNumber {

 // Your hashmap here:
 Map<String, Integer> map = new HashMap<String, Integer>();

 public int getSequenceNumber (String TcOrderId) {
  // ...
 }

public static void main(String[] args) throws IOException {

    // Instance of SequenceNumber object:
    SequenceNumber sequenceNumber = new SequenceNumber();

    String sCurrentLine;
    BufferedReader br = null;

    // ...
        while ((sCurrentLine = br.readLine()) != null) {
            //String orderid = sCurrentLine.substring(0, 6);
            System.out.println("reading line " +sCurrentLine);
            int seqvalue = sequenceNumber.getSequenceNumber(sCurrentLine);
            System.out.println("seqvalue "+seqvalue);
        }
    // ...
    }
}