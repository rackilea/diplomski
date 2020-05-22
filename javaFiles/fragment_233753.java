public static void main(String args[]) {
    JFrame f = new JFrame();

    f.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

    });

    f.getContentPane().setLayout(null);

    Dirt d = new Dirt(new Rectangle(40, 40));
    d.setBounds(20, 20, 64, 64);
    f.getContentPane().add(d);

    f.setSize(300, 300);

    f.setVisible(true);
}