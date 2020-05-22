class Main
 {
     public Main
     {
         CaravanData caravanData = new CaravanData();
         // Show the dialog - setVisible(true) blocks till ok is pressed
         caravanData.setVisible(true);

         // Once the user has finished - collect the data:
         CustomVariable data = caravanData.getRelevantData();
     }
 }

class CaravanData extends JDialog
{
    ...
    // Called by an ActionListener for the OK Button
    private void okButtonPressed(){
         setVisible(false);
    }

    public CustomerVariable getRelevantData()
    {
       ...
       return data;
    }
}