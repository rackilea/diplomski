import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class GUI extends JPanel implements ActionListener {

    // buttons
    private JButton newButton, findButton;
    JPanel panels;

    public void addComponentToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;

        createPanels();

        pane.add(panels, c);
    }

    private void createPanels() {
        JPanel mainMenu = createMainMenu();

        panels = new JPanel(new CardLayout());
        panels.add(mainMenu, "mainWindow");
        panels.add(new JLabel("Add card"), "add");
        panels.add(new JLabel("Find card"), "find");
    }

    private JPanel createMainMenu() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;

        JPanel mainMenu = new JPanel(new GridBagLayout());

        // add
        mainMenu.add(newButton = new JButton("Add"), c);
        newButton.setActionCommand("new");
        newButton.addActionListener(this);

        // find
        mainMenu.add(findButton = new JButton("Find"), c);
        findButton.setActionCommand("find");
        findButton.addActionListener(this);
        return mainMenu;
    }

    public void actionPerformed(ActionEvent e) {
        CardLayout allpanels = (CardLayout) (panels.getLayout());

        switch (e.getActionCommand()) {
        case "new":
            allpanels.show(panels, "add");
            break;

        case "find":
            allpanels.show(panels, "find");
            break;
        }
    }

    private static void createGUI() {

        JFrame frame = new JFrame("Check");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI contentPane = new GUI();
        contentPane.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createGUI();
    }
}