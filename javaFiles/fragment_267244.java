private String oldValue;

@Override
    public void keyPressed(KeyEvent e){
        if(condition == true){
            setText(oldValue);
            return;
        }
        oldvalue = getText();//Replace getText() with correct getter for current value
    }