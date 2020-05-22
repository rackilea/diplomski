KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(final KeyEvent e) {

                        // we only want PRESSED events  
                        if(e.getID() == KeyEvent.KEY_PRESSED){


                            int keyCode = e.getKeyCode();
                            if(keyCode == 37){
                                 System.out.print("Left");
                             }
                            else if (keyCode == 39){
                                 System.out.print("Right");
                            }
                            else if (keyCode == 32 ){
                                 System.out.print("JUMP");
                            }
                        }
                        return false;
                    }
                });