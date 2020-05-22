/**
 * This method does a swipe right
 * @author Bill Hileman
 */
public void swipeRight() {

    //The viewing size of the device
    Dimension size = driver.manage().window().getSize();

    //Starting x location set to 5% of the width (near left)
    int startx = (int) (size.width * 0.05);
    //Ending x location set to 95% of the width (near right)
    int endx = (int) (size.width * 0.95);
    //y position set to mid-screen vertically
    int starty = size.height / 2;

    scroll(startx, starty, endx, starty);

}