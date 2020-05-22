playerInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    String test = playerInput.getText().replaceAll("\\r|\\n", "");
                    String quit = "quit";
                    playerInput.setText("");
                    if(test.equalsIgnoreCase(quit))
                        System.exit(0);
                }
            }
            public void keyPressed(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });