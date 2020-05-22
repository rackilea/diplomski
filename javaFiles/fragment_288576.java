import java.net.Socket;
import javax.swing.JOptionPane;

public class SettingTimeout {

    public SettingTimeout() {
        Socket s = new Socket();            
        s.getSoTimeout();

    }

    public static void main(String[] args) {
    }
}