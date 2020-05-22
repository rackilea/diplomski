..................................
..................................
String sql = "INSERT INTO biodatum " + "(firstname, lastname, address, occupation, phone, email, image, gender, religion) "
        + " VALUES (?,?,?,?,?,?,?,?,?)";
PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1, firstname.getText());
pst.setString(2, lastname.getText());
pst.setString(3, address.getText());
pst.setString(4, occupation.getText());
pst.setString(5, phone.getText());
pst.setString(6, email.getText());
pst.setBytes(7, image_person);
pst.setString(8, gender.getSelectedItem().toString());
pst.setString(9, religion.getSelectedItem().toString());
pst.executeUpdate();  // ************ HERE ***************
..................................
..................................