import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerController implements ActionListener {
private JTextArea serverInfo;
private JLabel serverRunningState;
private JLabel serverConnectionStatus;
private JButton serverStartButton;

public ServerController(JButton serverStartButton,
                        JTextArea serverInfo,
                        JLabel serverRunningState,
                        JLabel serverConnectionStatus) {
    this.serverInfo = serverInfo;
    this.serverRunningState = serverRunningState;
    this.serverConnectionStatus = serverConnectionStatus;
    this.serverStartButton = serverStartButton;
}

@Override
public void actionPerformed(ActionEvent e) {
    server = new AppServer(Config.DEFAULT_PORT);

    if (server.isRunning()) { /* If this method is a boolean, putting
                                 (server.isRunning() == true) is pointless.
                                 It will either return true or not. */
        serverStartButton.setEnabled(false);
        serverStartButton.setText("Server Running");
        serverInfo.append(
            "Server started!\nWaiting for new clients...\n\n");
        serverInfo.setLineWrap(true);

        //change JLabel to "Server Online" from "Server Off-line"
        serverConnectionStatus.setText("Server Online");
        serverConnectionStatus.setForeground(Color.GREEN);
    }
}
}