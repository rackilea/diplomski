public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        JLabel label = new JLabel("Hello");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);

        label = new JLabel("Hello");
        label.setFont(new Font("Calibri", Font.PLAIN, 24));
        add(label, gbc);

        label = new JLabel("Hello");
        Font font = label.getFont();
        label.setFont(font.deriveFont(Font.PLAIN, 24f));
        add(label, gbc);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

}