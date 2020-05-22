private void makeFrame()
{
    frame = new JFrame("Game");

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    // ?? Don't know what this initialised to...
    contentPane.add(menubar, BorderLayout.NORTH);   
    //...
    makeMenuBar();
}

public void makeMenuBar(){
   // A local variable with the same name...??
   JMenuBar menubar = new JMenuBar();