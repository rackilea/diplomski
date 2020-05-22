JFrame frame = new JFrame();
    frame.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) 
            {
                System.out.println("Your code here!");
            }
        }
    });
    frame.setLocationRelativeTo(null);
    frame.setSize(200, 200);
    frame.setVisible(true);