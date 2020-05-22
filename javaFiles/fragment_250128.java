import javax.swing.*;
import java.awt.*;

public class View1 extends JPanel {
    final private MainFrame owner;

    public View1(MainFrame owner) {
        super();

        this.owner = owner;
        createGUI();
    }

    private void createGUI() {
        setLayout(new FlowLayout());
        add(new JLabel("View 1"));

        JButton button = new JButton("Show View 2");
        button.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> owner.showView(new View2(owner)));
        });

        add(button);
    }
}