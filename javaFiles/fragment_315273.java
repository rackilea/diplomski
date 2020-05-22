public void draw() {
    draw(true);  // retain current behavior
{

public void draw(boolean useWait) {
    if(isVisible) {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
            diameter, diameter));
        if (useWait) {
            canvas.wait(10);
        }
    }
}