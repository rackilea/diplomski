int x,xSpeed;

boolean movingLeft  = false;
boolean movingRight = false;

public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_LEFT){
        movingLeft = true;
    }
    if(key == KeyEvent.VK_RIGHT){
        movingRight = true;
    } 
}

public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_LEFT){
        movingLeft = false;
    }
    if(key == KeyEvent.VK_RIGHT){
        movingRight = false;
    } 
}

public void moving(){
    if(movingLeft){
        x -= xSpeed;
    }
    if(movingRight){
        x += xSpeed;
    }
}