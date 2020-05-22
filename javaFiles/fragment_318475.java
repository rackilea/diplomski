while(true){
    myImage.setX(myImage.getX() +1); /* change the x-position to x+1 */
    myImage.setY(myImage.getY() +1); /* change the y-position to y+1 */
    myCanvas.paint(); /* redraw your canvas */
    sleep(1/framerate); /* wait for 1/framerate seconds */ 
}