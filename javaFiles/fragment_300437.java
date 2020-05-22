public static void main(String[] args) 
{
    SwingUtilities.invokeLater(new Runnable() 
    {
        public void run() 
        {
            createAndShowGUI();             
        }
    });
}

private static void createAndShowGUI() 
{
    //1. Create the frame.
    JFrame frame = new JFrame("Defense Of The Origin");

    //2. Optional: What happens when the frame closes?
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //4. Size the frame.
    frame.setSize(SIZEX, SIZEY);

    //5. Show it.
    frame.setVisible(true);

    // Here, create an instance of "DotO", and add it to the frame!
    frame.add(new DotO());
}

// In the DotO constructor, only do what has to be done
// specifically for this DotO instance:
public DotO()
{
    setBorder(BorderFactory.createLineBorder(Color.black));
    loadBackground();  
    setBackground(Color.white);  
}