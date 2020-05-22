private static void createAndShowUI() {
    final CardLayout cardLayout = new MyCardLayout();
    final JPanel cardHolder = new JPanel(cardLayout);
    final JFrame frame = new JFrame("MultiSizedPanels");
    JLabel[] labels = {
        new JLabel("Small Label", SwingConstants.CENTER),
        new JLabel("Medium Label", SwingConstants.CENTER),
        new JLabel("Large Label", SwingConstants.CENTER)};

    for (int i = 0; i < labels.length; i++) {
        int padding = 50 * (i + 1);
        Border lineBorder = BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.blue),
            BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        labels[i].setBorder(lineBorder);
        JPanel containerPanel = new JPanel();
        containerPanel.add(labels[i]);
        cardHolder.add(containerPanel, String.valueOf(i));
    }
    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.next(cardHolder);
            frame.pack();
        }
    });
    JPanel btnHolder = new JPanel();
    btnHolder.add(nextButton);

    frame.add(cardHolder, BorderLayout.CENTER);
    frame.add(btnHolder, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocation(150, 150);
    frame.setVisible(true);
}