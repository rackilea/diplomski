DefaultListModel  model1= new DefaultListModel();

private void addActionPerformed(java.awt.event.ActionEvent evt) {                                     
      model1.addElement(desc.getText());
      jList2.setModel(model1);
      jList2.setSelectedIndex(0);
      desc.setText("");

}