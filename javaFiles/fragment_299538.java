public static void main(String[] args) {

    final JFrame first = new JFrame();
    first.setTitle("Hello");
    first.setSize(300, 100);
    first.setLocation(300, 100);

    first.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {

            // do other stuff....

            first.setVisible(false);
            first.dispose();
        }
    });

    first.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    first.setVisible(true);
}