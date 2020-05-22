public class tileGen extends Applet implements KeyListener  {

    Image[] tiles; // tile arrays
    Image player; // player image
    int x, y, px, py, tx, ty; // x tile - y tile // player x - player y // tile x - tile y
    boolean left, right, down, up, canMove; // is true?
    int[][] board; // row tiles for ultimate mapping experience!
    final int NUM_TILES = 25; // how many tiles are we implementing?
    Label lx, ly; // to see where we are!
    public final int BLOCKED = 1;

    int lastX, int lastY;  // <=== new member fields to track last X and last Y


    public void keyPressed(KeyEvent e) {

  //  UPDATE LAST X AND LAST Y IN THIS METHOD 
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    left = true;
                    px = px - 32;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    right = true;
                    px = px + 32;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    down = true;
                    py = py + 32;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                    up = true;
                    py = py - 32;
            }

            repaint();
    }


 }