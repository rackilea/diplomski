public class TextAreaDemo {

public static void main(String[] args) {
    final JTextArea textArea = new JTextArea(60, 5);

    final JScrollPane sp = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 300);
        }

    };

    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(sp);
    frame.pack();
    frame.setVisible(true);

    // Add the reader snippet here
}

}