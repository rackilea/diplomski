public class Application {

    private static List<JPanel> panels = new ArrayList<>();
    private static Container someContainer = new Container();

    public static void main(String[] args) {
        panels.add(addPanel(someContainer));
        panels.add(addPanel(someContainer));
        panels.add(addPanel(someContainer));

        submit();
    }

    public static JPanel addPanel(final Container pane) {
        JPanel panel1 = new JPanel();
        // shortened code
        final JComboBox<String> comboBox1 = new JComboBox<String>();
        panel1.add(comboBox1);

        final JTextField txtfield1 = new JTextField("Please enter your value here");
        txtfield1.setText(String.valueOf(Math.random()));
        panel1.add(txtfield1);
        return panel1;
    }

    private static void submit() {
        for (JPanel panel : panels) {
            Component[] components = panel.getComponents();
            for (Component comp : components) {
                // Cast comp to JComboBox / JTextField to get the values
                if (comp instanceof JTextField) {
                    JTextField textField = (JTextField) comp;
                    System.out.println(textField.getText());
                }
            }
        }
    }
}