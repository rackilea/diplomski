public class DetailsPanel extends JPanel {
    private final JPanel letterPanel;
    public DetailsPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(" click here "));

        letterPanel = new JPanel(new GridLayout(0, 5));
        ...
    }
    public void disableButtons() {
        for (Component c : letterPanel.getComponents()) {
          if (c instanceof JButton) c.setEnabled(false);
        }
    }
}