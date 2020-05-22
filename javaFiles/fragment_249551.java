public void collision(){
     Rectangle rectangle1 = thePlayer.bounds();//player rectangle 
     for (Square square: squareArray) {
        if(square.GetBounds().intersects(rectangle1)){//testing all squares vs player
            //if you are here a collision happened
            //you can remome square add score ...
        }  
    } 
 }