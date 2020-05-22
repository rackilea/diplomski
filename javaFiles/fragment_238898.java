JButton button = new JButton("NEXT FRAME");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String user = tf1.getText();
            String pass = tf2.getText();

            if (user.equals("Dominic") && (pass.equals("1234"))) {
                openFrame2();
                JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULL");

            } else {
                tf1.setText("");
                tf2.setText("");

                JOptionPane.showMessageDialog(null, "INCORRECT USERNAME OR PASSWORD");
            }
        }
    });
    panels.add(button);
    button.setBounds(500, 250, 150, 30);

}

protected static void openFrame2() {
    JFrame frame2 = new JFrame("NEW FRAME");
    frame2.setVisible(true);
    frame2.setSize(700, 500);
    frame2.setLocation(170, 100);
    JLabel label = new JLabel("YOU CLICKED ME");
    JPanel panel2 = new JPanel();
    frame2.add(panel2);
    panel2.add(label);
    panel2.setLayout(null);
    panel2.setBackground(new Color(13, 97, 150));
    label.setBounds(500, 250, 150, 30);
}