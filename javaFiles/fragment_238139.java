public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.setTitle("frame");
    JDialog dialog = new JDialog(frame, false);
    dialog.setTitle("dialog");
    final JButton button = new JButton("Click me");
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(button, "Hello");
        }
    });
    final JButton button2 = new JButton("Click me too");
    button2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(button2, "Hello dialog");
        }
    });
    frame.add(button);
    dialog.add(button2);
    frame.pack();
    dialog.pack();
    frame.setVisible(true);
    dialog.setVisible(true);
}