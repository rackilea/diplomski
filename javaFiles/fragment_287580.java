private DrawingPanel drawingPanel;
public Printing(String Firstname,String LastName,String contactid) 
{
    super("Print badge");
    //...
    drawingPanel = new DrawingPanel(Firstname,LastName,contactid);
    //...
}