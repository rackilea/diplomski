public class Framed {
    public static void workingFrame() {
        JFrame frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(createRightPanel(10, 10));

        frame.revalidate(); // <-- HERE
    }

    public static JPanel createRightPanel(int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JPanel pane = new JPanel();
                pane.setBackground((i+j)%2==0?Color.black:Color.white);
                panel.add(pane);
            }
        }
        return panel;
    }

    public static void main(String... none) throws Exception {
        workingFrame();
    }
}