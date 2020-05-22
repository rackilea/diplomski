int flag = 0;
if(usernameTF.getText().equals(user) && passwordTF.getText().equals(pass))
{
    flag=1; // if found then, value change to 1 otherwise it will be 0
}

//Now, put below condition after while loop
if (flag==1) {
    JOptionPane.showMessageDialog(null,"YEAAAA");
}
else {
    JOptionPane.showMessageDialog(null,"Account doesn't exist! Please try again.");                
}