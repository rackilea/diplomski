if (goingDown == true){
    // if we've gone down 50 pixels, start going up again
    if (yPosition <= 0){
        goingDown = false;
        yPosition++;
    }
    else {
        yPosition--; // move it down 1 pixel
    }
}
else {
    // if we're going up and we reach 0, go down again
    if (yPosition >= 50){
        goingDown = true;
        yPosition--;
    }
    else {
        yPosition++; // move it up1 pixel
    }
}

component.repaint(); // this will call the paint() method