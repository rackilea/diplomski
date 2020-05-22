public class ActionPane extends JPanel {

    private JButton btn;

    public ActionPane() {
        setLayout(new GridBagLayout());
        btn = new JButton("Add");
        add(btn);
    }

    public void addActionListener(ActionListener listener) {
        btn.addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        btn.removeActionListener(listener);
    }

}