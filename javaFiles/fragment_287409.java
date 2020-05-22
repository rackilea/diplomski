public class Test {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        JLabel label = new JLabel("Test");
        frame.getContentPane().add(label);
        frame.pack();

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent ev) {
                int result = JOptionPane.showConfirmDialog(frame, "Sure?");

                if (result == JOptionPane.OK_OPTION) {
                    frame.dispose();
                }
            }
        });

        frame.setVisible(true);
    }
}