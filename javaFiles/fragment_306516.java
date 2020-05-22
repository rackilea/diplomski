btSave.setActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        OwnerClass oc = new OwnerClass();

        oc.name = txtOwner.getText();
        oc.employeeNr = txtEmployeeNr.getText();

        myCC.addOwner(oc);
    }
});