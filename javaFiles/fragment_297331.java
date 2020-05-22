private void RegisterActionPerformed(java.awt.event.ActionEvent evt) { 
    myQ.remove();//remove first element
    System.out.print(myQ);
    mylist.setText("");
    mylist.append(myQ +" ");

  }