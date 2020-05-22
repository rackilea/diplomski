import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingWorker;

//better if the threading is done with a SwingWorker 
//to not run afoul of Swing threading rules
public class ChatWorker extends SwingWorker<Void, String> {
    private SSCCE2 sscce2 = null;
    private Scanner scanner = null;

    public ChatWorker(SSCCE2 sscce2, Socket socket) throws IOException {
        this.sscce2 = sscce2; // get the instance and assign to field
        scanner = new Scanner(socket.getInputStream());
    }

    @Override
    protected Void doInBackground() throws Exception {
        // this is called in a background thread
        while (scanner.hasNextLine()) {
            publish(scanner.nextLine());
        }
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        // this is called on the Swing event thread
        for (String text : chunks) {
            sscce2.append(text); // append the texts as they come in
        }
    }
}