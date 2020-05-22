lblWarn2.setText("");
        DefaultTableModel model =  (DefaultTableModel) tblSold.getModel();
        //get value at

        boolean kabTaken = false;

        for (int i = 0; i < tblSold.getModel().getRowCount(); i++) {

            if(cbCruises.getSelectedItem().toString().equals(tblSold.getValueAt(i, 0).toString())&cbCabin.getSelectedItem().toString().equals(tblSold.getValueAt(i,2).toString()))
            {
                kabTaken = true;
            } 
        }

        if (kabTaken) 
        {
            lblWarn2.setText("Cabin taken");             
        }
        else
        {
        model.addRow(new Object[]{cbCruises.getSelectedItem().toString(), txtBuyer.getText(),cbCabin.getSelectedItem().toString()});    

        }