public class GoodGridBagApp {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Font Chooser");
                frame.add(getMainPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }

            private JPanel getMainPanel() {

                JPanel mainPanel = new JPanel();
                GridBagConstraints gbc = new GridBagConstraints();
                mainPanel.setLayout(new GridBagLayout());
                mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

                gbc.gridx = 1;
                gbc.gridy = 2;

                JCheckBox cb = new JCheckBox("Bold");
                mainPanel.add(cb, gbc);
                gbc.gridy = 4;
                cb = new JCheckBox("Italic");
                mainPanel.add(cb, gbc);

                gbc.gridx = 2;
                gbc.gridy = 1;

                JRadioButton rb = new JRadioButton("Times");
                mainPanel.add(rb, gbc);
                gbc.gridy = 3;
                rb = new JRadioButton("Helvatica");
                mainPanel.add(rb, gbc);
                rb = new JRadioButton("Courier");
                gbc.gridy = 5;
                mainPanel.add(rb, gbc);

                return mainPanel;
            }
        });
    }
}