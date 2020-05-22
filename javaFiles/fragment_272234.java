public static void main(String args[]) throws Exception {

    final JFrame oldFrame = new JFrame("Test");

    oldFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            JFrame newFrame = new JFrame("Test");
            newFrame.setBounds(oldFrame.getBounds());
            newFrame.setVisible(true);
        }
    });
    oldFrame.setSize(400, 300);
    oldFrame.setVisible(true);
}