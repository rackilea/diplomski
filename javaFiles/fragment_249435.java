public PaintFrame()
{
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setVisible(true); // ***** telling Java to render the GUI
    setSize(1150, 650); 
    setLocationRelativeTo(null); 
    setResizable(false);
    setLayout(new BorderLayout());
    setTitle("Paint 2.0");

    addComponents(); // Add everything to the JFrame **after** rendering it! **
}