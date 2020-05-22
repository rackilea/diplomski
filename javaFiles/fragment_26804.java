public class EchoService extends Thread {
private Socket acceptedSocket;
private DataInputStream is;
private DataOutputStream os;

public EchoService(Socket acceptedSocket) {
    try {
        this.acceptedSocket = acceptedSocket;
        is = new DataInputStream(acceptedSocket.getInputStream());
        os = new DataOutputStream(acceptedSocket.getOutputStream());
    } catch (IOException e) {
        try {
            if (this.acceptedSocket != null)
                acceptedSocket.close();
            if(is != null)
                is.close();
            if(os != null)
                os.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}


@Override
public void run() {
    super.run();
    try {
        while (!acceptedSocket.isClosed()) {
            String usrMsg = is.readUTF();
            String serverMsg = "server: "+usrMsg;
            os.writeUTF(serverMsg);
            os.flush();
        }
    } catch (IOException e) {
        try {
            if(this.acceptedSocket != null)
                acceptedSocket.close();
            if(is != null)
                is.close();
            if(os != null)
                os.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}}