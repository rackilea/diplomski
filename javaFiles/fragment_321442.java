public static void main(String[] args) {
    Frame frame = new Frame("Lab33ast");
    frame.add(new GfxApp());
    frame.setSize(100, 750);
    frame.addWindowListener(new WindowAdapter() {
        public void
                windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });
    frame.setVisible(true);
}