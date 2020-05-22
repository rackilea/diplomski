FoxGui MyGUIRef;
public void actionPerformed(ActionEvent event) 
{ 
    System.out.println("Item: " + event.getActionCommand());

    // File Menu Controls
   if (event.getActionCommand().equals("New"))
   {
       MyGUIRef = runNew();
   }
}

//Now returns a reference to FoxGui
private FoxGui runNew()
{
     return new FoxGui(....)
}