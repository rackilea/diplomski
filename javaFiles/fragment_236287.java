class DispatcherListener implements KeyEventDispatcher{
    private int level=0;

    public boolean dispatchKeyEvent(KeyEvent e) {
        if(e.getID() == KeyEvent.KEY_RELEASED){
            if(e.isControlDown() && e.isShiftDown()){
                if(this.level==0 && e.getKeyCode()==KeyEvent.VK_S){
                    level++;
                }else if(this.level==1 && e.getKeyCode()==KeyEvent.VK_H){
                    level++;
                }else if(this.level==2 && e.getKeyCode()==KeyEvent.VK_O){
                    level++;
                }else if(this.level==3 && e.getKeyCode()==KeyEvent.VK_W){
                    level=0;
                    this.showHiddenWindow((JFrame)SwingUtilities.getRoot(e.getComponent()));
                }else{
                    level=0;
                }

                //System.out.println( "level: " +  level );
            }
        }
        return false;
    }