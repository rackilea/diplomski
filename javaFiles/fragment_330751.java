int emptyTile = 0;
//this assumes level is not a ragged array.
public boolean inBounds(int x, int y){
    return x>-1 && y>-1 && x<levelArray[0].length && y<levelArray.length;
}

public boolean checkForCollisions(Rectangle rectangle){
    boolean wasCollision = false;
    for(int x=0;x<rectangle.width && !wasCollision;x++){
        int x2 = x+rectangle.x;
        for(int y=0;y<rectangle.height && !wasCollision;y++){
             int y2 = y+rectangle.y;
             if(inBounds(x2,y2) && levelArray[y2][x2] != emptyTile){
                 //collision, notify listeners.
                 wasCollision=true;
             }
        }
    }
}