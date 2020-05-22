yourButton.addKeyListener(new KeyListener(){
         @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    snake.changeDirection(Point.NORTH);
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    snake.changeDirection(Point.SOUTH);
                }
                //Likewise for left and right arrows
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