public class GetKeycode implements KeyListener{

    private JFrame f;
    private JLabel feld;

    public GetKeycode(){
        f = new JFrame("GetKeycode");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(this);
        feld = new JLabel();
        f.add(feld);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        feld.setText(e.getKeyCode()+"");        
    }

    public static void main(String[] args) {
        new GetKeycode();
    }

    // Unused:
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent arg0) {}

}