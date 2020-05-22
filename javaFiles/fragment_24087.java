public static void main (String[] args){
        JFrame Win = new JFrame("Pong");
            Game game = new Game();
            Win.add(new Game());
            Win.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_UP){
                        ys = -1;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN){
                        ys = 1;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

            });
            Win.setResizable(false);
            Win.setSize(900, 600);
            Win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Win.setVisible(true);
            while (true) {
                shift();
                Win.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }   
      }
}