public class MessageReader {
private static final int SUBJECT_CHUNK = 0x0037;
private static final int BILLING_INFORMATION_CHUNK = 0x800A;
public static void main(String[] argv) {
    try {
        MAPIMessage mapiMessage = new MAPIMessage("MessageWithBillingInformation.msg");
        System.out.println(mapiMessage.getStringFromChunk(new StringChunk(SUBJECT_CHUNK, true)));
        System.out.println(mapiMessage.getStringFromChunk(new StringChunk(BILLING_INFORMATION_CHUNK, true)));
    } catch (IOException e) {
        e.printStackTrace();  
    } catch (ChunkNotFoundException e) {
        e.printStackTrace();  
    }
}