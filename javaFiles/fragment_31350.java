int clickNum = 0;
boolean hatSoundPlay = false;
while(true) { //while loop is always true
    int clickX = EZInteraction.getXMouse(); // declare an integer variable called clickX and the X mouse coordinate integer is assigned to it
    int clickY = EZInteraction.getYMouse(); // declare an integer variable called clickY and assign to it the Y mouse coordinate integer

    if (EZInteraction.wasMouseLeftButtonReleased()){  //if the left mouse button is released then
        if (hatPicture.isPointInElement(clickX, clickY)){ //if the left mouse button is release on this picture
            if (!hatSoundPlay) {
                hatsound.play(); //then hatsound will play
                hatSoundPlay = true;
            } else {
                EZ.addImage("hat.png", clickX, clickY); //hat.png will be placed
                hatSoundPlay = false;
            }
        }
    } 
}