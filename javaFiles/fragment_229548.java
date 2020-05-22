class Agent extends Thread
{
    @override
    public void run()
    {
       // run around the room

       // finally done
       gui.agentIsDone();
    }
}

class GUI extends JFrame
{
    ...

    void agentIsDone()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @override 
            public void run()
            {
                menus.setEnabled(true);
            }
        });
    } 
}