import java.net.*;

class SuperclassWithUnknownHostException {
    public SuperclassWithUnknownHostException() throws UnknownHostException {
        InetAddress firstMachineAddress = InetAddress.getByName("129.26.70.95");
        InetAddress secondMachineAddress = InetAddress.getByName("129.26.70.108");
    }
}

class SubclassCannotHandleException extends SuperclassWithUnknownHostException {

}