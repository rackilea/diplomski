jl.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                            int key = ke.getKeyCode();
                switch (key){
                             case KeyEvent.VK_DOWN:
                             case KeyEvent.VK_UP:
                             case KeyEvent.VK_RIGHT:
                             case KeyEvent.VK_LEFT:
                             case KeyEvent.VK_KP_DOWN:
                             case KeyEvent.VK_KP_UP:
                             case KeyEvent.VK_KP_RIGHT:
                             case KeyEvent.VK_KP_LEFT:
                    ke.consume();
                                    break;
                 default: 
                    }
        });