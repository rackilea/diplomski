public void keyPressed(KeyEvent e)
            {                
                if (e.getKeyChar() == 'x') {
                    System.out.println("Exiting");
                    System.exit(0);
                }
                else if (e.getKeyChar() == 'z') {
                    System.out.println("Resizing");
                }
            }