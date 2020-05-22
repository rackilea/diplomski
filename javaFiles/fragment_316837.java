public class TestPane extends JPanel {

    private JTextField inputURL;
    private JButton submitURL ;

    public TestPane() {
        setLayout(new BorderLayout());
        JLabel header = new JLabel("Header");
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(header, BorderLayout.NORTH);

        inputURL = new JTextField(20);
        submitURL = new JButton("Submit the URL");
        submitURL.setMargin(new Insets(10, 10, 10, 10));

        JPanel content = new JPanel(new GridLayout(2, 1));

        JPanel field = new JPanel(new GridBagLayout());
        field.add(inputURL);

        content.add(field);

        JPanel actions = new JPanel(new GridBagLayout());
        actions.add(submitURL);

        content.add(actions);

        add(content);
    }

}