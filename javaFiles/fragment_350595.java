private void BtnPreviousActionPerformed(ActionEvent evt) {        
    if (counter > 0) {
        counter--;
        Car carTemp = carsList.get(counter);

        txtId.setText(carTemp.getId());
        JcomboBrand.setSelectedItem(carTemp.getBrand());
        SpinnerDoors.setValue(carTemp.getDoors());
    } else {
        JOptionPane.showMessageDialog(this, "There are no records");
    }
}