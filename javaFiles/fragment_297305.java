public class TextColour implements KeyListener {
    JLabel label;
    String red = "<font color='FF0000'>";
    String blue = "<font color='0000FF'>";
    String text = "";
    boolean colour = false;

    public static void main(String[] args) {
        new TextColour();

    }

    public TextColour() {
        JFrame frame = new JFrame();
        JTextArea area = new JTextArea();

        area.addKeyListener(this);
        label = new JLabel();

        frame.setPreferredSize(new Dimension(400, 100));
        frame.getContentPane().add(area);
        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent key) {
        char letter = key.getKeyChar();
        if (colour) {
            if (letter == 'r') {
                text += red;
            } else if (letter == 'b') {
                text += blue;
            }
            colour = false;
        } else if (letter == '/') {
            colour = true;
        } else {
            text += key.getKeyChar();
        }
        label.setText("<html>" + text + "</html>");
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}