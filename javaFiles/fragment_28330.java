import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Connection extends Thread implements Runnable{

    private final Socket socket;
    private final DataOutputStream output;
    private final DataInputStream input;

    private final List<DataListener> listeners;

    public Connection(final Socket socket) throws IOException {
        this.socket = socket;

        listeners = new LinkedList<>();

        output = new DataOutputStream(socket.getOutputStream());
        output.flush();

        input = new DataInputStream(socket.getInputStream());

        setPriority(MAX_PRIORITY);
        start();
    }

    public void addDataListener(final DataListener l){
        listeners.add(l);
    }

    public void send(final byte opcode, final String message) throws IOException{
        output.writeByte(opcode);
        final byte[] bytes = message.getBytes("UTF-8");
        output.writeInt(bytes.length);
        output.write(bytes);
    }

    public boolean close(){
        try{
            output.close();
            input.close();
            socket.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            return socket.isConnected();
        }
    }

    private void fireDataListeners(final byte opcode, final String message){
        listeners.forEach(l -> l.dataReceived(this, opcode, message));
    }

    public void run(){
        while(true){
            try{
                final byte opcode = input.readByte();
                final byte[] bytes = new byte[input.readInt()];
                input.readFully(bytes);
                final String message = new String(bytes);
                fireDataListeners(opcode, message);
            }catch(IOException ex){
                ex.printStackTrace();
                close();
                break;
            }
        }
    }
}