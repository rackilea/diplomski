public void scaleContainer(Container c, double xFactor, double yFactor)
{
    Component[] eles = c.getComponents();
    for(int i = 0 ; i < eles.length ; i++)
    {
        eles[i].setBounds(new Rectangle(
             (int) eles[i].getX() * xFactor, 
             (int) eles[i].getY() * yFactor, 
             (int) eles[i].getWidth() * xFactor, 
             (int) eles[i].getHeight() * yFactor))
        if(eles[i] instanceof Container)
        {
            if(((Container)eles[i]).getLayout() == null) //If the container has it's own layout, let it assign it's own components
                scaleContainer((Conatiner)eles[i], xFactor, yFactor);
        }
    }
}