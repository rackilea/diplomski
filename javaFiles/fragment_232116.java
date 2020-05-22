public class AddScrollBarToJFrame {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JScrollPane scrollBar = new JScrollPane(panel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JFrame frame = new JFrame("AddScrollBarToJFrame");
        frame.add(scrollBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}