public class DialogTest {
    public static void main(String[] args) {

        final JFrame frame = new JFrame("Frame");
        JTextField field = new JTextField("Click me to open dialog!");
        field.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                JTextField f = (JTextField) e.getSource();
                Point l = f.getLocationOnScreen();

                JDialog d = new JDialog(frame, "Dialog", true);
                d.setLocation(l.x, l.y + f.getHeight());
                d.setSize(200, 200);
                d.setVisible(true);
            }
        });
        frame.add(field);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}