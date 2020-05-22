public class Test2 {
    public static void main(String[] args) {
        JFrame ablak = new JFrame("Snake game");
        ablak.setVisible(true);
        ablak.setSize(new Dimension(600,600));
        ablak.setFocusable(true);
        ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ablak.addKeyListener(new KeyListener(){
             @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_UP){
                        System.out.println("Hi");
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
        });
        ablak.setVisible(true);
    }
}