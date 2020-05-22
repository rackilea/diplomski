public Image capture(ArrayList<Monitor> monitors) 
{

    Rectangle bounds = new Rectangle();
    monitors.stream().forEach(a -> Rectangle.union(bounds, a.getBounds(), bounds) );

    Image image = null;

    try 
    {

        EventQueue.invokeAndWait(() -> frame.setExtendedState(Frame.ICONIFIED));

        while (frame.getExtendedState() != Frame.ICONIFIED) { }
        image = new Image(new Robot().createScreenCapture(bounds));

    } 
    catch (Exception ex) 
    {
        ex.printStackTrace();           
    }

    EventQueue.invokeLater(() -> frame.setExtendedState(Frame.NORMAL));

    return image;
}