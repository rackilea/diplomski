import javax.swing.*;
import java.awt.*;

public class View2 extends JPanel {
    final private MainFrame owner;

    public View2(MainFrame owner) {
        super();

        this.owner = owner;
        createGUI();
    }

    private void createGUI() {
        setLayout(new FlowLayout());
        add(new JLabel("View 2"));

        JButton button = new JButton("Show View 1");
        button.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> owner.showView(new View1(owner)));

        });

        add(button);
    }
}