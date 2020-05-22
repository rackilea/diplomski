public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JProgressBar pb1 = new JProgressBar();
        pb1.setValue(50);
        JProgressBar pb2 = new JProgressBar();
        pb2.setValue(25);

        add(pb1, gbc);

        gbc.insets = new Insets(4, 4, 0, 0);
        add(pb2, gbc, 0);
    }
}