int selectedOption = JOptionPane.showConfirmDialog(null, p, "Username and password: ", JOptionPane.YES_NO_OPTION); 
if (selectedOption == JOptionPane.YES_OPTION) {
if (userName.getText().equals("abc") && passWord.getText().equals("abc")) {
//do some action, login success
}
else
{
//do some action, login fail
}
}//end if
else
{
//do some action, means user cancel the login
}