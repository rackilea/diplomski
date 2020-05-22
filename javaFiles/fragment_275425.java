int showConfirmDialog = JOptionPane.showConfirmDialog(new JFrame(), "Approve?","Title",JOptionPane.YES_NO_OPTION);
    if(showConfirmDialog == JOptionPane.YES_OPTION){
        btnSave.setEnabled(false);
        btnEdit.setEnabled(true);
        txtName.setEnabled(false);
        //other fields
    } else {
        //If no or cancel actions
    }