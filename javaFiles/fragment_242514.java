private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            


        try {
            // TODO add your handling code here:

            DBManage db = new DBManage();

            if(db.checkUser(textUsername.getText(), textPassword.getText())){

                Welcome a= new Welcome();
                a.setVisible(true);
                a.setDefaultCloseOperation(Welcome.DISPOSE_ON_CLOSE);

                MESSAGE.setText("Login Successful");//I think this line will not be necessary here.

                close(); //<-----------------------------HERE

            }else{
                MESSAGE.setText("Wrong Password or Username");

            }



        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }