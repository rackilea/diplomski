public class Client {
    public DataOutputStream outStream;
    public DataInputStream  inStream; 

    public Client(DataOutputStream out, DataInputStream in) {
        this.outStream = out;
        this.inStream = in;
    }
}