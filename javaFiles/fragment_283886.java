public void paint(Graphics obj)
{
    // I can see you're trying to double buffer the graphics, but I would have a
    // buffer already set up...
    buffer = createImage(640,400);
    // You should NEVER dispose of Graphics context you didn't created...
    if (obj != null)
        obj.dispose();

    // Now we're really stuffed.  You've just overridden the screen graphics context
    obj = buffer.getGraphics();
    obj.setColor(getBackground());
    //update
    previouslocation = new Point(currentlocation);
    currentlocation = nextlocation;

    //draw
    obj.fillRect(currentlocation.x, currentlocation.y, size, size);
    obj.setColor(Color.black);
    obj.drawOval(nextlocation.x, nextlocation.y, size, size);
    obj.fillOval(nextlocation.x, nextlocation.y, size, size);
    /*
     *draw rectangles out of vector
     */
    // Now you drawing the buffer onto itself...???
    obj.drawImage(buffer, 0,0, null);
}