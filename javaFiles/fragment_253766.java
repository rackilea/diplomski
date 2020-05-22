private void onStuffChanged(String newStuff)
{
   Runnable changeText = new Runnable() {
       public void run() {
           myLabel.setText(newStuff);
       }
   };
   SwingUtilities.invokeLater(changeText);
}