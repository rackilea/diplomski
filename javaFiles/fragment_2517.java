public void actionPerformed(ActionEvent evt)
{
   Object source = evt.getSource();
   if (source == buttons[treasureLocation]) {

      buttons[treasureLocation].setIcon(image1);
   }
   else 
   {
      ((JButton) source).setIcon(someImageFile);
   }
}