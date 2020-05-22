ps = con.prepareStatement("INSERT INTO `user`(`username`, `realname`, `password`, `email`, `gym`, `belt`, `dateofbirth`, `profilepic`, `biography`, `motto`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
ps.setString(1, jTextFieldUsername.getText());
ps.setString(2, jTextFieldName.getText());
ps.setString(3, String.valueOf(jPasswordFieldPass.getPassword()));
ps.setString(4, jTextFieldEmail.getText());
ps.setString(5, jTextFieldGym.getText());
ps.setString(6, jComboBoxBelt.toString());
ps.setDate(7, convertUtilDateToSqlDate(jDateChooserDOB.getDate()));


InputStream img = new FileInputStream(new File(imagePath));
ps.setBlob(8, img);
ps.setString(9, jTextAreaBiography.getText());
ps.setString(10, jTextAreaMotto.getText());

if(ps.executeUpdate() != 0)
{
     JOptionPane.showMessageDialog(null, "Account Created!");
}
 else
{
    JOptionPane.showMessageDialog(null, "Oops! Something went wrong!");
}