public class EmailPanel extends JPanel {

    private JButton okButton;
    private JTextField serverIPTF;
    private JTextField serverPortTF;
    private JTextField domainNameTF;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().add(new EmailPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public EmailPanel() {

        init();
    }

    private void init() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel tPanel;
        JLabel tLabel;

// Header
        tLabel = new JLabel("Email Settings", JLabel.CENTER);
        tLabel.setAlignmentX(CENTER_ALIGNMENT);
        tLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, tLabel.getPreferredSize().height));
        tLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        add(tLabel);

// Fields
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setBorder(BorderFactory.createMatteBorder(5, 3, 5, 3, new Color(0, 0, 255, 255)));

// Top fields
        serverIPTF = new JTextField(10);
        serverIPTF.setMaximumSize(serverIPTF.getPreferredSize());
        serverPortTF = new JTextField(10);
        serverPortTF.setMaximumSize(serverPortTF.getPreferredSize());

        tPanel = new JPanel();
        tPanel.setLayout(new BoxLayout(tPanel, BoxLayout.X_AXIS));

        tPanel.add(new JLabel("Server IP Address:"));
        tPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        tPanel.add(serverIPTF);
        tPanel.add(Box.createRigidArea(new Dimension(25, 0)));
        tPanel.add(new JLabel("Server Port"));
        tPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        tPanel.add(serverPortTF);
        tPanel.add(Box.createHorizontalGlue());
        fieldsPanel.add(tPanel);

        fieldsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

// Lower field
        domainNameTF = new JTextField(10);
        domainNameTF.setMaximumSize(domainNameTF.getPreferredSize());

        tPanel = new JPanel();
        tPanel.setLayout(new BoxLayout(tPanel, BoxLayout.X_AXIS));

        tPanel.add(new JLabel("Domain Name:"));
        tPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        tPanel.add(domainNameTF);
        tPanel.add(Box.createHorizontalGlue());
        fieldsPanel.add(tPanel);

        add(fieldsPanel);

// OK Button
        okButton = new JButton("OK");
        okButton.setAlignmentX(CENTER_ALIGNMENT);
        add(okButton);
    }
}