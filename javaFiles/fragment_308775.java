public class WorkingHandler implements EventHandler<EventObject>
{
    public void handleEvent(EventObject event)
    {
        // handle event
        if (event instanceof MouseEvent)
            handleMouseEvent((MouseEvent) event);
        ...
    }

    ...

    private void handleMouseEvent(MouseEvent event)
    {
        // handle mice
    }
}