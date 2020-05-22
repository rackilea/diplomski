public class Snippet {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel leftBorder = new JPanel();
                JPanel rightBorder = new JPanel();
                leftBorder.setBackground(Color.black);
                rightBorder.setBackground(Color.black);

                JPanel center = new JPanel();
                center.setBackground(Color.red);

                f.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weighty = 1.0;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;

                gbc.gridx = 0;
                gbc.weightx = 0.1;
                f.add(leftBorder, gbc);

                gbc.gridx = 1;
                gbc.weightx = 0.8;
                f.add(center, gbc);

                gbc.gridx = 2;
                gbc.weightx = 0.1;
                f.add(rightBorder, gbc);

                f.pack();
                f.setVisible(true);
            }
        });
    }
}