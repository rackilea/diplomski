//arm image can be the same image if u want
    Image leftArm;
    Image rightArm;
    image headLegsAndTorsoLeft;
    image headLegsAndTorsoRight;
    //where am i looking in game if true i look to the leftside of user thats playing
    boolean turnedLeft
    //in paint
    if(turnedLeft){
    //this lets it look like he is turned to the left with his right arm in the visible behind his left.
    //draw right arm
    g2D.drawImage(rightArm,x,y,this);
    //draw body moved a bit in x coor
                g2D.drawImage(headLegsAndTorsoLeft,x-3,y,this);
   // draw left arm a bit more in x coor
    g2D.drawImage(leftArm,x-6,y,this);
    }else{
     //this lets it look like he is turned to the right with his left arm in the visible behind his right.
    // draw left arm
        g2D.drawImage(leftArm,x,y,this);
     //draw body moved a bit in x coor
        g2D.drawImage(headLegsAndTorsoRight,x-3,y,this);
 //draw right arm a bit more in x coor
        g2D.drawImage(rightArm,x-6,y,this);
        }