public static void main(String[] args) {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            // the GUI as seen by the user (without frame)
            JPanel gui = new JPanel(new BorderLayout());
            gui.setBorder(new EmptyBorder(2,3,2,3));

            // TODO!
            gui.setPreferredSize(new Dimension(400,100));
            gui.setBackground(Color.WHITE);

            JFrame f = new JFrame("Demo");
            f.add(gui);
            // Ensures JVM closes after frame(s) closed and
            // all non-daemon threads are finished
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // See http://stackoverflow.com/a/7143398/418556 for demo.
            f.setLocationByPlatform(true);

            // ensures the frame is the minimum size it needs to be
            // in order display the components within it
            f.pack();
            // should be done last, to avoid flickering, moving,
            // resizing artifacts.
            f.setVisible(true);
        }
    };
    // Swing GUIs should be created and updated on the EDT
    // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
    SwingUtilities.invokeLater(r);
}