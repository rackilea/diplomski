if (txtName.getText().trim().equals("")) {
    JOptionPane.showMessageDialog(null, "Must have name");
    jlblNameVer.setVisible(true);
} else {
    jlblNameVer.setVisible(false);

    //ID VERIFICATION
    if (txtIdNumber.getText().trim().equals("")) {
        JOptionPane.showMessageDialog(null, "Photo Id must not be emplty");
        passed = false;
    } else if (txtEmail == null || txtEmail.getText().length() < 10 || txtEmail.getText() == null || !(txtEmail.getText().trim().contains("@") && txtEmail.getText().trim().contains("."))) {
        JOptionPane.showMessageDialog(null, "Invalid Email");
        passed = false;
    } else if (txtPhoneNum.getText().length() < 10) {
        JOptionPane.showMessageDialog(null, "Must atleast 10 characters");
        passed = false;
    } else if (cmbStayDuration.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(null, "Please select stay duration");
        passed = false;
    } else if (cmbPhotoId.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(null, "Please select Photo ID type");
        passed = false;
    } else {

        //Popup form
        jfrmDetails nf1 = new jfrmDetails();
        jfrmDetails.txtRoomTypef2.setText(this.cmbRoomType.getSelectedItem().toString());
        jfrmDetails.txtRoomNumf2.setText(this.cmbRoomNumber.getSelectedItem().toString());
        jfrmDetails.txtCheckIn.setText(this.ftxtCheckinDate.getText());
        jfrmDetails.txtCheckOut.setText(this.txtCheckOut.getText());
        jfrmDetails.txtName.setText(this.txtName.getText());
        jfrmDetails.txtIdType.setText(this.cmbPhotoId.getSelectedItem().toString());
        jfrmDetails.txtIdNum.setText(this.txtIdNumber.getText());
        jfrmDetails.txtPhoneNum.setText(this.txtPhoneNum.getText());
        jfrmDetails.txtEmail.setText(this.txtEmail.getText());
        nf1.setVisible(true);

    }

}