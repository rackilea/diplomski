public class Main {
    public static void main(String[] args) {

       final TestFrame frame = new TestFrame();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
        frame.label.setText("Text From Main");
    }
}