import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable{

public GUI(){
    private JFrame frame = new JFrame("Yahtzee Game Server");

    //set the server online/off-line status to default color
    private JLabel serverConnectionStatus = new JLabel(GUIConfig.DEFAULT_SERVER_STATUS);
    serverConnectionStatus.setForeground(GUIConfig.DEFAULT_SERVER_STATUS_COLOR);

    //create the server events text area. It will hold all info
    //about server events including client connections/disconnections
    private JTextArea serverInfo = new JTextArea();
    serverInfo.setEditable(false);
    serverInfo.setPreferredSize(new Dimension(350, 450));

    //create the connect/disconnect button. Will be connect when server
    //is not connected and disconnect when server is connected
    private JButton serverRunningState = new JButton();
    serverRunningState.setText("Run Server");

    //Create JPanel with box layout
    private JPanel guiPanel = new JPanel();
    guiPanel.setLayout(new BoxLayout(guiPanel, BoxLayout.PAGE_AXIS));

    //add components to panel
    private JLabel serverInfoLabel = new JLabel(GUIConfig.DEFAULT_SERVER_EVENT_LABEL);
    guiPanel.add(serverInfoLabel);
    guiPanel.add(Box.createRigidArea(new Dimension(0,5)));
    serverInfo.setAlignmentX(Component.LEFT_ALIGNMENT); // Fixed the actual problem
    guiPanel.add(serverInfo);
    guiPanel.add(Box.createRigidArea(new Dimension(0,5)));
    serverConnectionStatus.setAlignmentX(Component.LEFT_ALIGNMENT); // Fixed the actual problem
    guiPanel.add(serverConnectionStatus);

    //create a bit of space around components so they get away from edges
    guiPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    //add panel to frame
    frame.add(guiPanel, BorderLayout.CENTER);

    //create new panel for buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

    //add connection button
    serverRunningState.setAlignmentX(Component.CENTER_ALIGNMENT);
    buttonPanel.add(serverRunningState);
    buttonPanel.add(Box.createRigidArea(new Dimension(0,5)));
    //add panel to frame
    frame.add(buttonPanel, BorderLayout.SOUTH);

    // Add ActionListener 
    serverRunningState.addActionListener(new ServerController(
        serverRunningState, serverInfo, serverInfoLabel, serverConnectionStatus
    ));

    //set size, do not allow resize and show
    frame.setSize(GUIConfig.DEFAULT_FRAME_WIDTH, GUIConfig.DEFUALT_FRAME_HEIGHT);
    frame.setResizable(false);
    frame.setVisible(true);

    //set it to terminate frame on exit
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

@Override
public void run() {
    // It seems to me folks like to include the code that sets the size,
    // close option, frame visibility, etc, here. But I don't believe it
    // necessary. However, any Swing gui you create needs to implement
    // Runnable and be instantiated in the manner shown in main().
    // See: https://bitguru.wordpress.com/2007/03/21/will-the-real-swing-single-threading-rule-please-stand-up/
}
public static void main(String args[]) {
    //SwingUtilities.invokeLater() is another method aside from EventQueue.invokeLater()
    SwingUtilities.invokeLater(new GUI());
}
}