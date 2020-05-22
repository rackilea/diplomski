@Override
public void paint( Graphics g )
{
    int width = getWidth();
    int height = getHeight();
    //Loops through all the layers in the order they were added
    //And tells them to paint onto this panels graphic context
    for(Painter painter : layerPainters)
    {
        painter.paint(g,this,width,height);
    }
}