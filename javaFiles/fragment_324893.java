public Main() //extends JFrame
{
    setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
    Board b = new Board(db); //extends JPanel
    setSize(400, 200); //size of the JFrame, JPanels size is set in its own constructor
    jsp = new JScrollPane(b); //adding the Board to the JScrollPane
    getContentPane().add(jsp); //adding the JScrollPane to the contentPane
    setVisible(true);
}