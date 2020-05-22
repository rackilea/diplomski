ActionListener actionListener = new ActionListener() {
  public void actionPerformed(ActionEvent actionEvent) {
    //System.out.println("Selected: " + cb.getSelectedItem());
     if(cb.getSelectedItem() == "student"){

       //Perform the action for student

     } 

      //Repeat this for all items

  }
};
cb.addActionListener(actionListener);