public class Scribble extends JFrame implements KeyListener {

    public Scribble(){
        this.setLayout(new BorderLayout());
        JTextField field = new JTextField();
        field.addKeyListener(this);
        /*
         * Disable tab, so we can catch it
         */
        field.setFocusTraversalKeysEnabled(false);
        this.add(field, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.getKeyCode());
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.getKeyCode());
    }

    public static void main(String[] args) {
        new Scribble();
    }
}