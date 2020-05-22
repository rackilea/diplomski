public void keyReleased(KeyEvent arg0){
            int code = arg0.getKeyCode();

            switch( code ) 
            { 
            case KeyEvent.VK_UP:
                System.out.println("UP " + list.getSelectedIndex());
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN " + list.getSelectedIndex());
                break;
            }
        }