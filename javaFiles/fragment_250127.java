import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel viewPanel;

    public MainFrame(String title) {
        super(title);
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(600, 480));

        viewPanel = new JPanel(new BorderLayout());
        add(viewPanel, BorderLayout.CENTER);

        showView(new View1(this));
        pack();
   }

   public void showView(JPanel panel) {
        viewPanel.removeAll();
        viewPanel.add(panel, BorderLayout.CENTER);
        viewPanel.revalidate();
        viewPanel.repaint();
   }
}