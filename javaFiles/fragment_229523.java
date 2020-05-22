public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            JFrame window = new JFrame();
            window.setTitle("Deadlock");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(new TestDeadlock());
            window.pack();
            window.setVisible(true);
        }
    });
}