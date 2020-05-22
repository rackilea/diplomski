//this resets the position/size of the snake and clears the array
public void reset() {
    snake.clear();
    apples.clear();
    xCoor = 10;
    yCoor = 10;
    size = 20;
    running = true;
}


private class Key implements KeyListener {
    //reset when you are dead and the user presses r
    if (!running && (e.getKeyChar() == 'r' || e.getKeyChar() == 'R')){
        reset();
    }
}


public void tick() {
    while (running){

        //prev code

        for(int i = 0; i < snake.size(); i++) {
            if(xCoor == snake.get(i).getxCoor() && yCoor ==  snake.get(i).getyCoor()) {
                if(i != snake.size() - 1) {
                    //don't kill the process, just stop the game and wait for the user to press 'r'
                    //you may need to do additional stuff here
                    running = false;
                }
            }
        }

        //remaining code
    }
}