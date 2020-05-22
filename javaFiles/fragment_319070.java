@Override
public void run()
{
    // We're outside the EDT in most of run()
    m_IsAnimationNeeded = true;
    for (JPanelRailoadSquare currRailoadSquare: m_PlayerRailoadPanelsTrack)
    {
        SwingUtilities.invokeAndWait(new Runnable() {
            // The code that "talks" to Swing components has to be put on
            // the EDT
            currRailoadSquare.SetGoingTrain();
            repaint();
        });

        // We want to keep sleeping outside the EDT.
        try
        {
            Thread.sleep(150);
        }
        catch (InterruptedException e){}

        SwingUtilities.invokeAndWait(new Runnable() {
            currRailoadSquare.UnSetGoingTrain();
            repaint();                       
        }
    }
}