JTable one= new JTable();
  JTable two= new JTable();
  ComboBoxModel combo = comboBox.getModel();

 for(JPanel t: getTable())
  {  
       if(combo.getSelectedItem().equals(t.getName()))
       {
          one=t;
       }
  }