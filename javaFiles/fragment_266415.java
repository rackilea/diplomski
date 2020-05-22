public class TestInPaneChoosers {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                buildFrame();
            }
        });
    }

    private static void buildFrame() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setLayout(new FlowLayout());

        f.add(new JFileChooser());
        f.add(new JFileChooser());

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}