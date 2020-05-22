class Mylistener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == someButton){
             // do something
         } else if (e.getSource() == someOtherButton){
             // do something
         } 
         // add more else if statements for other components
         // e.getSource() is the component that fires the event e.g. someButton
    }
}