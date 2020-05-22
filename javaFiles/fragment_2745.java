private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.SOUTH);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().remove(numberPanel);
            numberPanel = new NumberPanel();
            frame.getContentPane().add(numberPanel, BorderLayout.CENTER);
            frame.pack();
        }
    });
    panel.add(btnNewButton);

    numberPanel = new NumberPanel();
    frame.getContentPane().add(numberPanel, BorderLayout.CENTER);
    frame.pack();
}