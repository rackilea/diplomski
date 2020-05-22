// Listens for closing event
frame.addWindowListener(new WindowAdapter()
{
    public void windowClosing(WindowEvent e)
    {
        // Do stuff
        socket.close(); // Make sure socket is visible here
    }
});