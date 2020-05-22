public void addRow(String jtable_element){

     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     Object[] obj = {jtable_element};
     model.addRow(obj);

    }