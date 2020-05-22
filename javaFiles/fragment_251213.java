//these set out the current position of your rectangle
double recX, reYy, recH, recW;

//this gives something to manage speed
int speed;

public void paintComponent(Graphics g) {
    g.drawRectangle(recX,rexY,recH,recW);
}

//here we work out the movement
public void clickedScreen(double x, double y){
    double newX = x;
    double newY = y;
    //calculate the speed to move at
    vX = newX - recX;
    vY = newY - recY;
    //get the distance
    length = Math.sqrt((v1*v1)+(v2*v2));
    //make it a unit vector
    v1 = v1/length;
    v2 = v2/length;
}

public moveRec(){
    recX = recX+(v1*speed);
recY = recY+(v2*speed);
}

while(true) {
    moveRec();
    repaint();
}