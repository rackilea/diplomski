import javax.swing.JPanel;
public class NumberPanel extends JPanel {
    private static int counter = 0;
    public NumberPanel() {
        setLayout(new BorderLayout(0, 0));
        JLabel lblNewLabel = new JLabel("" + counter++);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel);
    }
}