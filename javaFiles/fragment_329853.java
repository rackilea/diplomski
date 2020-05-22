private void setKeyBind(){
    if(clickedRectangle == null){
        lastKeyChar = '\u0000';
        lastKeyCode = 0;
    }
    if(lastKeyChar != '\u0000'){
        clickedRectangle = null;
    }
}

public void keyPressed(int key, char c){  //Overrides BasicGameState
    if(clickedRectangle != null && lastKeyChar == '\u0000'){
            lastKeyChar = c;
            lastKeyCode = key;
            System.out.println("Key: "+c + " KeyCode: "+key);
    }
}